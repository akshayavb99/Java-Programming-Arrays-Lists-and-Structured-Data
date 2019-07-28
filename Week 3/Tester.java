import java.io.*;
import java.util.*;
import java.lang.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author Akshaya Balaji 
 * @version July 28,2019
 */
public class Tester {
    
    public void testLogEntry()
    {
        LogEntry le=new LogEntry("1.2.3.4",new Date(),"example request",200,500);
        System.out.println(le);
        LogEntry le2=new LogEntry("1.2.3.4",new Date(),"example request",200,500);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer()
    {
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("weblog2_log");
        //obj.printAll();
        //System.out.println(obj.countUniqueIPs());
        //System.out.println("Number of unique visits on given day is: "+obj.uniqueIPVisitsOnDay("Sep 24").size());
        //obj.printAllHigherThanNum(400);
        //System.out.println("Number of IPs in the given range is: "+obj.countUniqueIPsInRange(400,499));
        HashMap<String,Integer> counts=obj.countVisitsPerIP();
        /*for (String key:counts.keySet())
        {
            System.out.println(key+" : "+counts.get(key));
        }*/
        //System.out.println("Number of unique IPs: "+counts.size());
        //System.out.println("Maximum number of visits by an IP is "+obj.mostNumberVisitsByIP(counts));
        //System.out.println("IPs with most number of visits: "+obj.iPsMostVisits(counts));
        HashMap<String,ArrayList<String>> days=obj.iPsForDays();
        //System.out.println(days);
        //System.out.println("Day with maximum IP visits: "+obj.dayWithMostIPVisits(days));
        obj.iPsWithMostVisitsOnDay(days, "Sep 30");
    }
    
    public void testUniqueIP()
    {
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("short-test_log");
        obj.countUniqueIPs();
    }

}
