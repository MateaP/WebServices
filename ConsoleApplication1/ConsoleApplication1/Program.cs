using Microsoft.Xml.XQuery;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            XQueryNavigatorCollection col = new XQueryNavigatorCollection();
            col.AddNavigator("C:\\Users\\matea\\workspace\\test\\my-file.xml", "doc");

            string query = "for $x in document(\"doc\")/dsKurs/KursZbir return (<p>{$x/Oznaka/text(), \" \", $x/Nomin/text(), \" \", $x/Sreden/text()}</p>)";


            XQueryExpression xepr = new XQueryExpression(query);
            string result = xepr.Execute(col).ToXml();
            String html = "<html>" + result + "</html>";

            using (FileStream fs = new FileStream("D:\\test.htm", FileMode.Create))
            {
                using (StreamWriter w = new StreamWriter(fs, Encoding.UTF8))
                {
                    w.WriteLine(html);
                }
            } 

            Console.Write(result);
            Console.ReadKey();
        }
    }
}
