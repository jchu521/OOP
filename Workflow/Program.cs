using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Workflow
{

    class Program
    {
        static void Main(string[] args)
        {
            WorkflowEngine workflowEngine = new WorkflowEngine();
            List<IActivity> activities = new List<IActivity>();

            activities.Add(new FirstActivity());
            activities.Add(new SecondActivity());

            workflowEngine.Run(new Workflow(activities));

        }
    }
}
