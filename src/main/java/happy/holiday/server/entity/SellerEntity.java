package happy.holiday.server.entity;

import java.util.List
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "seller")
public class SellerEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String phone_number;
	private String password;
	private String fio;
	private Integer age;

	@OneToMany
	@JoinColumn(name = "item_id")
	private List<ItemEntity> listOfItems;

	@OneToMany
	@JoinColumn(name = "item_id")
	private List<OrderEntity> listOfOrders;

	@OneToMany
	@JoinColumn(name = "item_id")
	private List<ItemEntity> history;
}
