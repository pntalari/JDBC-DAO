package daos;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T extends DTO> {

    protected final Connection connection;

    public Dao(Connection conn){
        super();
        this.connection = conn;
    }


    public abstract T findById(Integer id);

    public abstract List findAll();

    public abstract T update(T dto);

    public abstract T create(T dto);

    public abstract void delete(Integer id);
}
