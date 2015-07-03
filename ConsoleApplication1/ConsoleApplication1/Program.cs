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

            string query = "for $x in document(\"doc\")/dsKurs/KursZbir return ($x/Oznaka/text(), \" \", $x/Nomin/text(), \" \", $x/Sreden/text(), \" \")";


            XQueryExpression xepr = new XQueryExpression(query);
            string result = xepr.Execute(col).ToXml();
            string[] res = result.Split(' ');
            int k = 0;
            for (int i = 0; i < 32; i++)
            {
                Console.WriteLine(res[k++] + " " + res[k++] + " " + res[k++]);
            }
            Console.ReadKey();
        }
    }
}
