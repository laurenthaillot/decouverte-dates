package co.simplon.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DecouverteDates {

	public DecouverteDates() {
		super();
	}

	public boolean estInferieurDateCourante(Date date) throws ParseException {
		Date aujourdhui = new Date();
		if (aujourdhui.before(date)) {
			return false;
		}
		return true;
	}

	public Date construireDate(String chaineFournie) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(chaineFournie);
			System.out.println("Date parsée : " + date);

		} catch (Exception e) {
			System.err.println("Format de date invalide. Usage : dd/MM/YYYY");
			System.err.println(e.getMessage());
		}
		return date;

		// String date = "4";
		// String month = "4";
		// String year = "2017";
		// String hourOfDay = "0";
		// String minute ="0";
		//
		//
		// Calendar cal = Calendar.getInstance();
		// cal.clear();
		//
		// cal.set(year, month, date, hourOfDay, minute);

	}

	public Date augmenterDate(Date dateInitiale, int nombreJours,
			int nombreHeures, int nombreMinutes) {

		Calendar calendrier = Calendar.getInstance();
		calendrier.setTime(dateInitiale);

		calendrier.add(Calendar.DAY_OF_MONTH, nombreJours);
		calendrier.add(Calendar.HOUR_OF_DAY, nombreHeures);
		calendrier.add(Calendar.MINUTE, nombreMinutes);

		Date datemodifie = calendrier.getTime();
		return datemodifie;

	}

	public String formaterUneDate(Date date) {
	
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_yyyy");
		String dateF = df.format(date.getTime());
		return dateF;
	}

	public String formaterUneHeure(Date time) {
			
		SimpleDateFormat hf = new SimpleDateFormat("HH");
		SimpleDateFormat mf = new SimpleDateFormat("mm");
		SimpleDateFormat sf = new SimpleDateFormat("ss");
		String heureF = hf.format(time);
		String minuteF = mf.format(time);
		String secondeF =sf.format(time);
		
		return heureF + "h" +minuteF + "min" + secondeF + "sec";
	}

	public String formaterDateEnFrancais(Date date) {
		
		SimpleDateFormat dfr = new SimpleDateFormat("EEEE dd MMMM yyyy");
		String dateFr = dfr.format(date);
		return dateFr;
		
	}
}
