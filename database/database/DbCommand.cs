using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace database
{
    class DbCommand 
    {
        private readonly DbConnection _connection;
        private readonly string _instruction;

        public DbCommand(DbConnection connection, string instruction) 
        {
            if (connection == null || string.IsNullOrWhiteSpace(instruction))
            {
                throw new InvalidOperationException("fail");
            }
            else
            {
                this._connection = connection;
                this._instruction = instruction;
            }
        }

        public void Execute()
        {
            this._connection.Open();
            Console.WriteLine(this._instruction);
            this._connection.Close();
        }

    }
}
