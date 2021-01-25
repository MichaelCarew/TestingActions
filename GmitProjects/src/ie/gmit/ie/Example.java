package ie.gmit.ie;

public class Example {
		public int process(int number, String day) {
			int value=0;
			switch (day) {
			case "Monday":
				value = 1;
				break;
			case "Tuesday": 
			case "Wednesday": 
			case "Thursday":
				value = 2;
				break;
			case "Friday":
				value = 3;
				break;
			
		    case "Saturday": 
			case "Sunday":
		value = 0;
		break;
	      
			default:
				value = -1;
			}
			return value + number;
		}
}
