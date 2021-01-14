package lu_dokuments.statistic;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Statistic_functions {

public void timeStatistic(LocalDateTime date1, LocalDateTime date2){
    System.out.println("Stated:" + date1);
    System.out.println("Ended: " + date2);
    int diffInNano = java.time.Duration.between(date1, date2).getNano();
    long diffInSeconds = java.time.Duration.between(date1, date2).getSeconds();
    long diffInMilli = java.time.Duration.between(date1, date2).toMillis();
    System.out.printf("\nDifference is  %d Seconds, %d Milli, and %d Nano\n\n",  diffInSeconds, diffInMilli, diffInNano );

    System.out.println("End student generation");
    }

}
