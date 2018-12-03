package mandatory.school.administration.Services.user;

import mandatory.school.administration.Model.User;

import java.util.List;

public interface UserService
{
    User createUser(User user);

    User findUserByUsername(String username);

    void editUser(User user);

    void deleteUser(User user);

    void deleteUserById(int id);

    List<User> getAllUsers();

    long countUsers();
}
