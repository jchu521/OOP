using System.Data;

namespace Workflow
{
    public class WorkflowEngine
    {
        public void Run(Workflow workflow)
        {
            foreach (var activity in workflow.Activities)
            {
                if (activity == null)
                {
                    throw new InvalidExpressionException("Fail");
                }
                activity.Execute();
            }
        }
    }
}