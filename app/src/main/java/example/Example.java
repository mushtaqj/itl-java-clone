package example;

import org.arabeyes.itl.prayer.*;
import org.arabeyes.itl.prayer.astro.Direction;
import org.arabeyes.itl.prayer.astro.Location;

import java.util.Date;
import java.util.Locale;

public class Example {

    public static void main(String[] args) {
        showPrayerTime();
    }

    public static void showPrayerTime() {
        System.out.println("=== PRAYER TIME ===");
        
        /* As an example, we use the location of Depok (West Java, Indonesia) and
         * Egyptian General Authority of Survey method. */
        Location location = new Location( -34.93, 138.6, +5.5, 0);
        Method method = Method.MUSLIM_LEAGUE;
        
        /* Instantiate the calculator. */
        PrayerTimeCalc calculator = new PrayerTimeCalc(location, method);
        
        /* Calculate prayer times for today. */
        Date date = new Date();
        PrayerTimes prayerTimes = calculator.getPrayerTimes(date);
        PrayerTime imsakTime = calculator.getImsak(date);
        
        /* Print it (using default locale). */
        TimeNames names = TimeNames.getInstance(Locale.getDefault());
        System.out.printf("%s\t%s:%s\n",
                names.getImsak(),
                imsakTime.getHour(),
                imsakTime.getMinute());
        for (int i = 0; i < 6; ++i) {
            System.out.printf("%s\t%s:%s\n",
                    names.get(i),
                    prayerTimes.get(i).getHour(),
                    prayerTimes.get(i).getMinute());
        }

        printQibla(calculator);
    }

    public static void printQibla(PrayerTimeCalc calculator){

        calculator.getNorthQibla().getDecimalValue(Direction.SOUTH);
    }
}
