package holidays;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
	//función que retorna la fecha de pago
	public static LocalDate payDate(int year, int month, int day){
		boolean isPayDay = false;
		int monthHoliday = month;
		//fecha inicial dada por el usuario
		LocalDate inputDate = LocalDate.of(year, month, day);
		//Es festio o no es festivo
		Boolean holiday = new Holiday(year).isHoliday(monthHoliday, day);
		//Si el rango de meses ingresado por el usuario está entre enero y febrero		
		if(month >= 1 && month <= 12){
			//validación para cuando el usuario quiere saber el día de pago de mitad de mes
			if(day >= 1 && day <= 15){
				monthHoliday -= 1;
				int minusDay = 15;
				LocalDate newDate = LocalDate.of(year, month, minusDay);
				while(newDate.getDayOfWeek() == DayOfWeek.SATURDAY || newDate.getDayOfWeek() == DayOfWeek.SATURDAY || holiday == true || isPayDay == false){
					holiday = new Holiday(year).isHoliday(monthHoliday, minusDay);
					if(holiday != true && newDate.getDayOfWeek() != DayOfWeek.SATURDAY && newDate.getDayOfWeek() != DayOfWeek.SATURDAY){
						isPayDay = true;
						inputDate = newDate;
					}
					newDate = newDate.minusDays(1);					
					minusDay--;				
				}
			//validación para cuando el usuario quiere saber el día de pago de fin de mes	
			}else if(day >= 16 && day <= 31){
				monthHoliday -= 1;
				int minusDay = 30;
				LocalDate newDate = LocalDate.of(year, month, minusDay);
				while(newDate.getDayOfWeek() == DayOfWeek.SATURDAY || newDate.getDayOfWeek() == DayOfWeek.SUNDAY || holiday == true || isPayDay == false){
					holiday = new Holiday(year).isHoliday(monthHoliday, minusDay);
					if(holiday != true && newDate.getDayOfWeek() != DayOfWeek.SATURDAY && newDate.getDayOfWeek() != DayOfWeek.SATURDAY){
						isPayDay = true;
						inputDate = newDate;
					}
					newDate = newDate.minusDays(1);					
					minusDay--;
				}
			}						
		} else {
			System.out.println("Ingresa un mes válido!");
		}
		System.out.println(inputDate);
		return inputDate;
    }
	public static void main(String[] args) {
		//probando la función	
		payDate(2022, 1, 10);
	}

}
