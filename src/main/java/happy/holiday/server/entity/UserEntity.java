
package happy.holiday.server.entity;

import java.util.ArrayList;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//TODO: Добавить уникальность столбца
	private String phone_number;
	private String password;

	private String fio;
	private Integer age;

	@OneToMany
	@JoinColumn(name = "item_id")
	private ArrayList<OrderEntity> listOfOrders;
}
