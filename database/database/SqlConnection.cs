using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace database
{
    class SqlConnection :DbConnection
    {
        public SqlConnection(string ConnectionString) : base(ConnectionString)
        {
        }

        public override void Open()
        {
            Console.WriteLine("sql open");
        }

        public override void Close()
        {
            Console.WriteLine("sql close");
        }
    }
}
