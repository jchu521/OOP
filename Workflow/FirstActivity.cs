using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Workflow
{
    public class FirstActivity : IActivity
    {
        public void Execute()
        {
            Console.WriteLine(("First"));
        }
    }
}
