using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Stopwatch
{
    public class Stopwatch1
    {
        public bool isStart = false;
        public double TimeSpan { get; set; }
        public DateTime startTime;
        public DateTime stopTime;
        public double totlTime;

        public void run()
        {
            var input = Console.ReadLine();

            while(input =="start" || input =="stop")
            {
                if (input == "start")
                {
                    Start();
                }
                if (input == "stop")
                {
                    Stop();
                }
                input = Console.ReadLine();
            }


        }

        public void Start()
        {
            startTime = DateTime.Now;
            isStart = true;
        }

        public void Stop()
        {
            stopTime = DateTime.Now;
            TimeSpan = (stopTime - startTime).TotalSeconds;
            isStart = false;
            totlTime += TimeSpan;
            Console.WriteLine("Duration is" + TimeSpan+"\n Total Time is " + TimeSpan);
        }
    }
}
