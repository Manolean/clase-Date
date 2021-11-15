package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}

	//METODOS GET

	public int getDay(){
		return this.day;
	}
	public int getMonth(){
		return this.month;
	}
	public int getYear(){
		return this.year;
	}


	//METODOS IS SAME
	public boolean isSameYear(Date date){
		return this.getYear() == date.getYear();
	}

	public boolean isSameMonth(Date date){
		return this.getMonth() == date.getMonth();
	}

	public boolean isSameDay(Date date){
		return this.getDay() == date.getDay();
	}

	public boolean isSameNoIf(Date date){
		return isSameDay(date)&& isSameMonth(date) && isSameYear(date);
	}

	//METODO GETMONTHNAME

	public String getMonthName(){
		StringBuilder salida =  new StringBuilder();
		switch (this.month) {
			
			case 1: 
				salida.append("January") ;
				break;
			case 2: 
				salida.append("February") ;
				break;
			case 3: 
				salida.append("March") ;
				break;
			case 4: 
				salida.append("April");
				break;
			case 5: 
				salida.append("May") ;
				break;
			case 6: 
				salida.append("June") ;
				break;
			case 7: 
				salida.append("July") ;
				break;
			case 8: 
				salida.append("August") ;
				break;
			case 9: 
				salida.append("September") ;
				break;
			case 10: 
				salida.append("October") ;
				break;
			case 11: 
				salida.append("November") ;
				break;
			case 12: 
				salida.append("December") ;
				break;		
		}
		return salida.toString();
	}
	public boolean checkMonth(){
		boolean checkMonth;
		if (month > 0 && month < 13) {
			if (month == 2 && day > 28) {
				checkMonth = false;
			}
			checkMonth = true;
		}else {
			checkMonth = false;
		}
		return checkMonth;
	}

	public String getSeasonName(){

		StringBuilder salida = new StringBuilder();
		switch (this.month) {
			case 3:
			case 4:
			case 5:
				salida.append("Spring");
				break;
			case 6:
			case 7:
			case 8:
				salida.append("Summer");
				break;
			case 9:
			case 10:
			case 11:
				salida.append("Autumn");
				break;
			case 12:
			case 1:
			case 2:
				salida.append("Winter");
				break;
			}
			return salida.toString();
		}
	
	public String getMonthsLeft(){

		StringBuilder salida = new StringBuilder();
		int aux = this.month;
			if (this.month == 12) {
				salida.append("0 meses restantes");
			}
	
			for (int i = this.month+1 ; i <= 12 ; i++) {
				this.month+=1;
				 salida.append(getMonthName());
				 salida.append(" ");
				 
			}
		this.month= aux;
		return salida.toString();
		}

	public String stringVersionDate(){

		return this.day + " de " + this.getMonthName() + " de " + this.year;
	
		}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	

}
