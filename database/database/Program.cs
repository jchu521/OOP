using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace database
{
    class Program
    {

        static void Main(string[] args)
        {
            try
            {
                var command = new DbCommand(new SqlConnection("sql"), "sql");
                var command2 = new DbCommand(new OracleConnection("sql"), "oracle");
                command.Execute();
                command2.Execute();
                Console.ReadLine();
            }
            catch (System.Exception e)
            {
                System.Console.WriteLine(e.Message);
            }
        }
    }
}
