package happy.holiday.server.controllers;

import happy.holiday.server.dto.UserDto;
import happy.holiday.server.entity.UserEntity;
import happy.holiday.server.factory.UserDtoFactory;
import happy.holiday.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Возможно, что не стоит писать @autowired, если присвоить соотв. 
//полям индеф. final и к классу добавить @AllArgsConstructor (Проверить)

@RestController
@RequiredArgsConstructor
class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDtoFactory userDtoFactory;

	public static final String AUTHORIZE    = "api/users/authorize";
	public static final String REGISTRATION = "api/users/registration";

	@Transactional
	@GetMapping(AUTHORIZE)
	public ResponseEntity<UserDto> login(@RequestParam String phone_number,
								   	     @RequestParam String password) throws NotFoundException {
			
		// FIX: Почему-то не работает лямбда выражение, пофиксить
		var userEntity = userRepository
			.findTopByPhoneNumberAndPassword(phone_number, password)
			.orElseThrow(NotFoundException::new);  // <= вон тут

		return ResponseEntity.ok(userDtoFactory.createUserDto(userEntity));
	}


	@Transactional
	@PostMapping(REGISTRATION)
	public ResponseEntity<UserDto> registration(@RequestParam String phone_number,
								   	     		@RequestParam String password,
												@RequestParam String fio,
												@RequestParam Integer age) throws NotFoundException {
			
		// FIX: Почему-то не работает лямбда выражение, пофиксить
		var userEntity = userRepository
			.findTopByPhoneNumberAndPassword(phone_number, password)
			.orElseThrow(NotFoundException::new);  // <= вон тут

		return ResponseEntity.ok(userDtoFactory.createUserDto(userEntity));
	}
}

