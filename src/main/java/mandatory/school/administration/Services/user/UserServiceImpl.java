package mandatory.school.administration.Services.user;

import mandatory.school.administration.Model.User;
import mandatory.school.administration.Repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository repository;

    @Override
    public User createUser(User user)
    {
        return repository.save(user);
    }

    @Override
    public User findUserByUsername(String username)
    {
        return repository.findUserByUsername(username);
    }

    @Override
    public void editUser(User user)
    {
        repository.save(user);
    }

    @Override
    public void deleteUser(User user)
    {
        repository.delete(user);
    }

    @Override
    public void deleteUserById(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers()
    {
        return repository.findAll();
    }

    @Override
    public long countUsers()
    {
        return repository.count();
    }
}
