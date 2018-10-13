package ru.innopolis.stc13.repository.dao.implementDao;

import ru.innopolis.stc13.pojo.Role;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.repository.dao.interfaceDao.RoleDao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class RoleDaoImpl implements RoleDao {
    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public int add(Role role) {
        int i = 0;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO role VALUES (DEFAULT, ?)");
            preparedStatement.setString(1, role.getName());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                i = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Role getByLogin(int id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM role WHERE role.id = ?");) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return new Role(resultSet.getInt(1),
                            resultSet.getString(2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Role> getAll() {
        Set<Role> roles = null;
        try (Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM role")) {
                roles= new HashSet<>();
                while (resultSet.next()) {
                    roles.add(new Role(
                            resultSet.getInt(1),
                            resultSet.getString(2))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

}

