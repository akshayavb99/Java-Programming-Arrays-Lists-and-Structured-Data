
/**
 * Write a description of UniqueIPTester here.
 * 
 * @author Akshaya Balaji 
 * @version July 28,2019
 */
public class UniqueIPTester {
    public void testUniqIP()
    {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs=la.countUniqueIPs();
        System.out.println("There are "+uniqueIPs+" unique IPs");
    }

}
