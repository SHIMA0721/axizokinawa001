package db;
/** 今月のカレンダーを表示 */
import java.util.Calendar;

public class Cal {

  /** 最初に呼び出されるメソッド */
    public static void main( String argv[] ) {

        int year = searchYear();
        int month = searchMonth();
        int day = searchStartDay();
        show( year, month, day );
    }

  /** 今年が西暦何年か調べるメソッド */
    public static int searchYear() {

        Calendar cal = Calendar.getInstance();
        int result = cal.get( Calendar.YEAR );
        return result;
    }

  /** 今が何月かを調べるメソッド
   *  1月が1, 2月が2,.....
   */
    public static int searchMonth() {

        Calendar cal = Calendar.getInstance();
        int result = cal.get( Calendar.MONTH ) + 1;
        return result;
    }

  /** 今月の１日が何曜日かを調べるメソッド
   *  日曜日が1, 月曜日が2,......
   */
    public static int searchStartDay() {

        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.DATE, 1 );
        int result = cal.get( Calendar.DAY_OF_WEEK );
        return result;
    }

  /** 月が何日までかを調べるメソッド */
    public static int searchLastDay( int year, int month ) {

        int[] table
           = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int result = table[ month-1 ];

        if( month == 2 && year%4 == 0 ) {
            result = 29;
            if( year%100 == 0 && year%400 != 0 )
                result = 28;
        }
        return result;
    }

  /** カレンダー表示のメソッド */
    public static void show( int year, int month, int day ) {

      // 月が何日までかを調べる
       int last = searchLastDay( year, month ); 
       int today = 1;

      // 1行目 月と年
       if( month < 10 )
           System.out.print( "       " + month + "月 " + year );
       else
           System.out.print( "      " + month + "月 " + year );
       System.out.println( "" ); //改行

      // 2行目 曜日の表示
       System.out.println( " 日 月 火 水 木 金 土" );

      // 3行目 日付の最初の行の表示
       for( int i=0; i<day-1; i++ ) {
           System.out.print( "   " );
       }
       for( int i=day-1; i<7; i++ ) {
           System.out.print( "  " + today );
           today++;
       }
       System.out.println( "" );

      // 4行目以降 日付の表示
       int youbi = 1;
       while( today <= last ) {
           if( today < 10 )
               System.out.print( "  " + today );
           else
               System.out.print( " " + today );
           if( youbi%7 == 0 )
               System.out.println( "" ); // 改行
           today++; youbi++;
       }
       if( youbi%7 !=1 )
           System.out.println( "" ); // 改行
   }
}