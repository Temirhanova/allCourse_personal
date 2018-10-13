package ru.innopolis.stc13.repository.dao.implementDao;

import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.repository.dao.interfaceDao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public User getByLogin(String login) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" WHERE \"user\".login = ?");) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return new User(resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getInt(4));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(User user) {
        int i =0;
        try(Connection connection = connectionManager.getConnection()) {
/*            Manufacturer manufacturer = manufacturerDao.getById(mobile.getManufacturer().getId());
            int idOfManufacrurer;
            if (manufacturer == null){
                idOfManufacrurer = manufacturerDao.add(mobile.getManufacturer());
            } else {
                idOfManufacrurer = manufacturer.getId();
            }*/

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"user\" VALUES (DEFAULT, ?, ?, ?)");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if ( resultSet.next() ) {
                i = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Set<User> getAll() {
        Set<User> users = null;
        try (Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM \"user\"")) {
                users = new HashSet<>();
                while (resultSet.next()) {
                    users.add(new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
