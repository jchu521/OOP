using System.Collections.Generic;
using System.Runtime.InteropServices;

namespace Workflow
{
    public partial class Workflow
    {

        public List<IActivity> Activities { get; }

        public Workflow(List<IActivity> activities)
        {
            Activities = activities;
        }

    }
}