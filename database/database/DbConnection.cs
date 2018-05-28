using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace database
{
    abstract class DbConnection
    {
        private string _connectionString;
        private TimeSpan _timeOut;

        public string ConnectionString
        {
            get { return _connectionString; }
            set { _connectionString = value;}
        }

        public TimeSpan TimeOut
        {
            get { return _timeOut; }
            set { _timeOut = value; }
        }

        public DbConnection(string connection)
        {
            if (connection == null)
            {
                throw new InvalidOperationException("Connection String is not define");
            }
            else
            {
                this._connectionString = connection;
            }
        }

        public abstract void Open();
        public abstract void Close();
    }
}
