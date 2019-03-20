package daos;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T extends DTO> {

    protected final Connection connection;

    public Dao(Connection conn){
        super();
        this.connection = conn;
    }


    public abstract Object findById(Integer id);

    public abstract List findAll();

    public abstract Object update(Object dto);

    public abstract Object create(Object dto);

    public abstract void delete(Integer id);
}
