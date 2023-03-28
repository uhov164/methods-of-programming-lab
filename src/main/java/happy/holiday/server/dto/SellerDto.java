package happy.holiday.server.dto;

import java.util.List;
import lombok.Data;

@Data
public class SellerDto {
	private String phone_number;
	private String fio;
	private int age;

	private List<ItemDto> items;
	private List<OrderDto> orderHistory;
}
