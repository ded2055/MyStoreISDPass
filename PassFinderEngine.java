import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

/**
 * Created by Ded on 09.03.2016.
 */
public class PassFinderEngine implements ActionListener {

    MyStoreISDPass parent;
    PassFinderEngine(MyStoreISDPass parent){
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] passISD = new char[6];
        String[] currentDate = parent.date.getText().split("-");

        int month = parseInt(currentDate[1]);
        passISD[0] = (char) ('b' + valueOf(month-1));

        char[] day = currentDate[2].toCharArray();
        passISD[1] = (char) ('a' + parseInt(String.valueOf(day[0])));
        passISD[2] = (char) ('a' + parseInt(String.valueOf(day[1])));

        if(LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY) passISD[3] = 'p';
        else if(LocalDate.now().getDayOfWeek() == DayOfWeek.TUESDAY) passISD[3] = 'v';
        else if(LocalDate.now().getDayOfWeek() == DayOfWeek.WEDNESDAY) passISD[3] = 's';
        else if(LocalDate.now().getDayOfWeek() == DayOfWeek.THURSDAY) passISD[3] = 'c';
        else if(LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY) passISD[3] = 'p';
        else if(LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY) passISD[3] = 's';
        else if(LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) passISD[3] = 'v';

        char[] restNum = parent.numRestField.getText().toCharArray();

        passISD[4] = (char) ('a' + parseInt(String.valueOf(restNum[0])));
        passISD[5] = (char) ('a' + parseInt(String.valueOf(restNum[1])));

            parent.passLabel.setText(String.valueOf(passISD[0])+passISD[1]+passISD[2]+passISD[3]+passISD[4]+passISD[5]);
        }


}
