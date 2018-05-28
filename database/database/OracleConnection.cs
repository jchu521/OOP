using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace database
{
    class OracleConnection : DbConnection
    {

        public OracleConnection(string ConnectionString) : base(ConnectionString)
        {
            
        }

        public override void Open()
        {
            Console.WriteLine("oracle open");
        }

        public override void Close()
        {
            Console.WriteLine("oracle close");
        }
    }
}
