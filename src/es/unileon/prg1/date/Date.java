package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	//CONSTRUCTOR DE LA CLASE

	public Date (int day, int month, int year) throws DateException {
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}
	
	//METODOS SET

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
	
	//METODO DIAS DE CADA MES

	public int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: 
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10: 
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

	//METODO NOMBRE DE CADA MES

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

	//METODO CHECK DEL MES

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

	//METODO NOMBRE DE LA ESTACION

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
	
	//METODO MESES RESTANTES
		
	public String getMonthsLeft(){

		StringBuilder salida = new StringBuilder();
		int aux = this.month;
			if (this.month == 12) {
				salida.append("0 meses restantes.");
			}
	
			for (int i = this.month+1 ; i <= 12 ; i++) {
				this.month+=1;
				 salida.append(getMonthName());
				 salida.append(" ");
				 
			}
		this.month= aux;
		return salida.toString();
		}

	//METODO DE LA VERSION STRING DE DATE

	public String stringVersionDate(){

		return this.day + " de " + this.getMonthName() + " de " + this.year;
	
		}
	
	//METODO FECHAS RESTANTES DEL MES

	public String getDatesLeftOfMonth(){
		StringBuilder salida = new StringBuilder();

		switch (this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				for (int i=this.day+1; i<=31 ; ++i ) {
					
					salida.append(i + "/"+ this.month+"/"+this.year);
					
					salida.append(" ");
				}
				break;
			case 2:
				for (int i=this.day+1; i<=28 ; ++i ) {
					
					salida.append(i + "/"+ this.month+"/"+this.year);
					salida.append(" ");
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				for (int i=this.day+1; i<=30 ; ++i ) {
					
					salida.append(i + "/"+ this.month+"/"+this.year);
					salida.append(" ");
				}
				break;
		}
		return salida.toString();
	}

	//METODO MESES CON EL MISMO NUMERO

	public String getSameNumberMonth() {
		StringBuilder salida = new StringBuilder();
		switch (this.month) {
		case 1: 
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10: 
		case 12:
			salida.append("Enero Marzo Mayo Julio Agosto Octubre Diciembre");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			salida.append("Abril Junio Septiembre Noviembre");
			break;
		case 2:
			salida.append("Febrero");
			break;			
		}
		
		return salida.toString();
	}

	//METODO DIAS DESDE EL PRINCIPIO DE AÑO

	public int daysSinceFirstDay(){
		int daysFromBegining=0;
		for (int i = 1;i<this.month ; i++) {
		 	switch (i) {
		 		case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
					daysFromBegining += 31;
					break;
				case 2:
					daysFromBegining += 28;
					break;
				case 4:
				case 6:
				case 9:
				case 11:	
					daysFromBegining += 30;
					break;
		 	}
		} 
		daysFromBegining += this.day-1;

		return daysFromBegining;
	}

	//METODOS INTENTOS FECHA WHILE Y DO-WHILE

	public int numRandomTriesEqualDateWhile(){	
		int randomDay=365;
		int attempts =0;
		
		while(this.daysSinceFirstDay() != randomDay) {
			randomDay = (int)(Math.random()*((364-0)+1))+0;
			attempts++;
		}
		return attempts;
	}

	public int numRandomTriesEqualDateDoWhile(){	
		int randomDay=365;
		int attempts =0;
		
		do  {
			randomDay = (int)(Math.random()*((364-0)+1))+0;
			attempts++;
		}
		while(this.daysSinceFirstDay() != randomDay);
		return attempts;
	}

	public String dayOfWeek(int firstDayOfYear){

		StringBuilder salida = new StringBuilder();
		
		int dayOfWeek = (this.daysSinceFirstDay()%7)+firstDayOfYear;
			switch (dayOfWeek) {
				case 7:
					salida.append("Sunday");
					break;
				case 1:
					salida.append("Monday");
					break;
				case 2:
					salida.append("Tuesday");
					break;
				case 3:	
					salida.append("Wednesday");
					break;
				case 4:
					salida.append("Thursday");
					break;
				case 5:
					salida.append("Friday");
					break;
				case 6:
					salida.append("Saturday");
					break;
			}
		return salida.toString();
	}

	//METODO TOSTRING
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	

}
