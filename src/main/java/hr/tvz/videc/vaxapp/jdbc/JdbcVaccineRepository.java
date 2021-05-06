package hr.tvz.videc.vaxapp.jdbc;

import hr.tvz.videc.vaxapp.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine;
import hr.tvz.videc.vaxapp.model.VaccineDTO;
import hr.tvz.videc.vaxapp.repository.VaccineRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

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
        return jdbc.query("select vaxName, compName, type, neededDoses, warehouseDoses from vaccine",
                this::mapRowToVaccine);
    }

    private Vaccine mapRowToVaccine(ResultSet rs, int i) throws SQLException {
        Vaccine vaccine = new Vaccine();
        vaccine.setVaxName(rs.getString("vaxName"));
        vaccine.setCompName(rs.getString("compName"));
        vaccine.setType(rs.getString("type"));
        vaccine.setNeededDoses(rs.getInt("neededDoses"));
        vaccine.setWarehouseDoses(rs.getLong("warehouseDoses"));
        return vaccine;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        return jdbc.query("select vaxName, compName, type, neededDoses, warehouseDoses from vaccine where vaxName = ?",
                this::mapRowToVaccine, researchName).stream().findFirst();
    }

    @Override
    public List<Vaccine> findVaccineByWarehouseDosses(long requestedWarehouseDosses) {
        return new ArrayList<>(jdbc.query("select vaxName, compName, type, neededDoses, warehouseDoses from vaccine where warehouseDoses = ?",
                this::mapRowToVaccine, requestedWarehouseDosses));
    }

    @Override
    public Optional<Vaccine> addVaccine(VaccineCommand vaccineCommand) {
        vaccineCommand.setVaxName(addVaccineDetails(vaccineCommand));
        return Optional.of(mapCommandToVaccine(vaccineCommand));
    }

    private String addVaccineDetails(VaccineCommand vaccineCommand){
        Map<String, Object> values = new HashMap<>();

        values.put("vaxName", vaccineCommand.getVaxName());
        values.put("compName", vaccineCommand.getCompName());
        values.put("type", vaccineCommand.getType());
        values.put("neededDoses", vaccineCommand.getNeededDoses());
        values.put("warehouseDoses", vaccineCommand.getWarehouseDoses());

        vaccineInserter.execute(values);
        return vaccineCommand.getVaxName();
    }

    @Override
    public Optional<Vaccine> updateVaccine(String vaxName, VaccineCommand vaccineCommand) {
        Optional<Vaccine> vaccineToRemove = findAll().stream().filter( x -> x.getVaxName().equals(vaxName)).findFirst();
        if (vaccineToRemove.isEmpty()) {
            return Optional.empty();
        }
        addVaccineDetails(mapVaccineToCommand(vaccineToRemove.get()));
        return vaccineToRemove;
    }

    @Override
    public List<Vaccine> findVaccinesByNumberOfWarehouseDoses(long warehouseDosesMin, long warehouseDosesMax) {
        return new ArrayList<>(jdbc.query("select vaxName, compName, type, neededDoses, warehouseDoses from vaccine where warehouseDoses >= ? and warehouseDoses <= ?",
                this::mapRowToVaccine, warehouseDosesMin, warehouseDosesMax));
    }

    @Override
    public void deleteVaccine(String vaxName) {
        jdbc.update("DELETE FROM vaccine WHERE vaxName LIKE ?", vaxName);
    }

    private Vaccine mapCommandToVaccine(VaccineCommand vaccineCommand){
        return new Vaccine(vaccineCommand.getVaxName(), vaccineCommand.getCompName(), vaccineCommand.getType(), vaccineCommand.getNeededDoses(), vaccineCommand.getWarehouseDoses());
    }

    private VaccineCommand mapVaccineToCommand(Vaccine vaccine){
        return new VaccineCommand(vaccine.getVaxName(), vaccine.getCompName(), vaccine.getType(), vaccine.getNeededDoses(), vaccine.getWarehouseDoses());
    }

}
