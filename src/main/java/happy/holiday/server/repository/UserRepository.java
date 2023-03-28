package happy.holiday.server.repository;

import happy.holiday.server.entity.UserEntity;
import java.util.Optional;
import io.micrometer.common.lang.NonNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findTopByPhoneNumberAndPassword(@NonNull String phoneNumber, @NonNull String password);
}
