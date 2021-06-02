package hr.tvz.videc.vaxapp.repository;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcVaccineRepository implements VaccineRepository {
    private JdbcTemplate jdbc;
    private SimpleJdbcInsert vaccineInserter;


    public JdbcVaccineRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.vaccineInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("vaccine").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Vaccine> findAll() {
        return jdbc.query("select research_name, manufacturer_name, type, number_of_shots, available_doses from vaccine",
                this::mapRowToVaccine);
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        return jdbc.query("select research_name, manufacturer_name, type, number_of_shots, available_doses from vaccine where research_name = ?",
                this::mapRowToVaccine, researchName).stream().findFirst();
    }

    @Override
    public List<Vaccine> findVaccineByAvailableDoses(long requestedAvailableDoses) {
        return new ArrayList<>(jdbc.query("select research_name, manufacturer_name, type, number_of_shots, available_doses from vaccine where available_doses > ?",
                this::mapRowToVaccine, requestedAvailableDoses));
    }

    @Override
    public List<Vaccine> findVaccinesByNumberOfAvailableDoses(long availableDosesMin, long availableDosesMax) {
        return new ArrayList<>(jdbc.query("select research_name, manufacturer_name, type, number_of_shots, available_doses from vaccine where available_doses >= ? and available_doses <= ?",
                this::mapRowToVaccine, availableDosesMin, availableDosesMax));
    }

    @Override
    public Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand) {
        vaccineCommand.setResearchName(addVaccineDetails(vaccineCommand));
        return Optional.of(mapCommandToVaccine(vaccineCommand));
    }

    private String addVaccineDetails(VaccineCommand vaccineCommand){
        Map<String, Object> values = new HashMap<>();

        values.put("research_name", vaccineCommand.getResearchName());
        values.put("manufacturer_name", vaccineCommand.getManufacturerName());
        values.put("type", vaccineCommand.getType());
        values.put("number_of_shots", vaccineCommand.getNumberOfShots());
        values.put("available_doses", vaccineCommand.getAvailableDoses());

        vaccineInserter.execute(values);
        return vaccineCommand.getResearchName();
    }

    private Vaccine mapRowToVaccine(ResultSet rs, int i) throws SQLException {
        Vaccine vaccine = new Vaccine();
        vaccine.setResearchName(rs.getString("research_name"));
        vaccine.setManufacturerName(rs.getString("manufacturer_name"));
        vaccine.setType(rs.getString("type"));
        vaccine.setNumberOfShots(rs.getInt("number_of_shots"));
        vaccine.setAvailableDoses(rs.getLong("available_doses"));
        return vaccine;
    }

    @Override
    public Optional<Vaccine> updateVaccine(String research_name, VaccineCommand vaccineCommand) {
        Optional<Vaccine> vaccineToRemove = findVaccineByResearchName(research_name);
        if (vaccineToRemove.isEmpty()) {
            return Optional.empty();
        }
        deleteVaccine(research_name);
        addVaccineDetails(vaccineCommand);
        return Optional.of(mapCommandToVaccine(vaccineCommand));
    }

    @Override
    public void deleteVaccine(String research_name) {
//        Optional<Vaccine> targetVaccine = findVaccineByResearchName(research_name);
//        Long id = targetVaccine.get().getId();
//        jdbc.update("DELETE FROM side_effect WHERE vaccine_id = ?", id);
        jdbc.update("DELETE FROM vaccine WHERE research_name LIKE ?", research_name);
    }

    private Vaccine mapCommandToVaccine(VaccineCommand vaccineCommand){
        return new Vaccine(vaccineCommand.getResearchName(), vaccineCommand.getManufacturerName(), vaccineCommand.getType(), vaccineCommand.getNumberOfShots(), vaccineCommand.getAvailableDoses());
    }

    private VaccineCommand mapVaccineToCommand(Vaccine vaccine){
        return new VaccineCommand(vaccine.getResearchName(), vaccine.getManufacturerName(), vaccine.getType(), vaccine.getNumberOfShots(), vaccine.getAvailableDoses());
    }

}
