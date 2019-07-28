import java.io.*;
import java.util.*;
import java.lang.*;
import edu.duke.*;
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author Akshaya Balaji 
 * @version July 28,2019
 */
public class LogAnalyzer {

    private ArrayList<LogEntry> records;
    public LogAnalyzer()
    {
        records=new ArrayList<LogEntry>();
    }
    
    public void readFile(String filename)
    {
        FileResource fr  = new FileResource(filename);
        for (String line:fr.lines())
        {
            LogEntry obj=WebLogParser.parseEntry(line);
            records.add(obj);
        }
        //printAll();
    }
    
    public void printAll()
    {
        for (LogEntry le:records)
        {
            System.out.println(le);
        }
        System.out.println(" ");
    }
    
    public int countUniqueIPs()
    {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records)
        {
           String ipAddr=le.getIpAddress();
                if (!uniqueIPs.contains(ipAddr))
                {
                    uniqueIPs.add(ipAddr);
                }
        }
        return uniqueIPs.size();
    }
    
    public void printAllHigherThanNum(int num)
    {
        for (LogEntry le:records)
        {
            int statusNum=le.getStatusCode();
            if (statusNum>num)
            {
                System.out.println(le);
            }
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday)
    {
        ArrayList<String> uniqueIPs=new ArrayList<String>();
        for (LogEntry le:records)
        {
            String date=(le.getAccessTime()).toString();
            if (date.contains(someday))
            {
                String ipAddr=le.getIpAddress();
                if (!uniqueIPs.contains(ipAddr))
                {
                    uniqueIPs.add(ipAddr);
                }
            }
        }
        
        return uniqueIPs;
    }
    
    public int countUniqueIPsInRange(int low,int high)
    {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le:records)
        {
            int statusNum=le.getStatusCode();
            if (statusNum>=low&&statusNum<=high)
            {
                String ipAddr=le.getIpAddress();
                if (!uniqueIPs.contains(ipAddr))
                {
                    uniqueIPs.add(ipAddr);
                    //System.out.println(le);
                }
                
                
            }
        }
        return uniqueIPs.size();
    }
    
    public HashMap<String,Integer> countVisitsPerIP()
    {
        HashMap<String,Integer> counts=new HashMap<String,Integer>();
        for (LogEntry le:records)
        {
            String ip=le.getIpAddress();
            if(!counts.containsKey(ip))
            {
                counts.put(ip,1);
            }
            else
            {
                counts.put(ip,counts.get(ip)+1);
            }
        }
        return counts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> counts)
    {
        int max=0;
        for (String key:counts.keySet())
        {
            int val=counts.get(key);
            if (val>max)
            {
                max=val;
            }
        }
        return max;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts)
    {
        ArrayList<String> arr=new ArrayList<String>();
        int max=mostNumberVisitsByIP(counts);
        for (String key:counts.keySet())
        {
            int val=counts.get(key);
            if (val==max)
            {
                arr.add(key);
            }
        }
        return arr;
    }
    
    public HashMap<String,ArrayList<String>> iPsForDays()
    {
        HashMap<String,ArrayList<String>> days=new HashMap<String,ArrayList<String>>();
        for(LogEntry le:records)
        {
            String day=le.getAccessTime().toString().substring(4,10);
            String ip=le.getIpAddress();
            //System.out.println(day);
            if (!days.containsKey(day))
            {
                ArrayList<String> arr=new ArrayList<String>();
                arr.add(ip);
                days.put(day,arr);
            }
            else
            {
                ArrayList<String> arr=days.get(day);
                arr.add(ip);
                days.put(day,arr);
            }
        }
        return days;
    }
    
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> days)
    {
        String max_day="";
        int max_val=0;
        for (String day:days.keySet())
        {
            int val=days.get(day).size();
            if(max_val<val)
            {
                max_val=val;
                max_day=day;
            }
        }
        return max_day;
    }
    
    public void iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> days, String day)
    {
        ArrayList<String> arr=days.get(day);
        HashMap<String,Integer> counts=new HashMap<String,Integer>();
        for (String s:arr)
        {
            if(!counts.containsKey(s))
            {
                counts.put(s,1);
            }
            else
            {
                counts.put(s,counts.get(s)+1);
            }
        }
        ArrayList<String> iPsCount=iPsMostVisits(counts);
        System.out.println(iPsCount);
    }
}
