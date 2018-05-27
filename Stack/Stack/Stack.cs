using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Stack
{

    public class Stack
    {
        public ArrayList array = new ArrayList();

        public void Push(Object obj)
        {
            if (obj == null)
            {
                throw new InvalidOperationException("Fail");
            }
            else
            {
                array.Add(obj);
            }
        }

        public object Pop()
        {
            if (array.Count == 0)
            {
                throw new InvalidOperationException("Fail");
            }
            else
            {
                Object value = array[array.Count - 1];
                array.RemoveAt(array.Count-1);
                return value;
            }
        }

        public void Clear()
        {
            array.Clear();
        }
    }
}
