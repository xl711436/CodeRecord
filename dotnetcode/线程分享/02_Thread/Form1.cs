using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace _02_Thread_ThreadPool
{
    public partial class Form1 : Form
    {
        private Thread curThread;

        private bool threadFlag;

        private int count = 0;

      
        public Form1()
        {
            InitializeComponent();
        }

        private void Btn_ThreadInfo_Click(object sender, EventArgs e)
        {
            curThread = Thread.CurrentThread; 
            Tb_ThreadInfo.Text = GetThreadInfo(curThread); 
        }



        private string GetThreadInfo(Thread I_Thread)
        {
            StringBuilder R_Result = new StringBuilder();

            R_Result.Append("BasePriority： " + I_Thread.Priority + Environment.NewLine);


            R_Result.Append("ManagedThreadId： " + I_Thread.ManagedThreadId + Environment.NewLine);
          
            R_Result.Append("Name： " + I_Thread.Name + Environment.NewLine);
            R_Result.Append("ThreadState： " + I_Thread.ThreadState + Environment.NewLine);
        //    R_Result.Append("IsBackground： " + I_Thread.IsBackground + Environment.NewLine);
            R_Result.Append("IsThreadPoolThread： " + I_Thread.IsThreadPoolThread + Environment.NewLine);
         //   R_Result.Append("IsAlive： " + I_Thread.IsAlive + Environment.NewLine); 
            return R_Result.ToString();
        }

        private void Btn_SetThread_Click(object sender, EventArgs e)
        {
            curThread = Thread.CurrentThread; 
            curThread.Priority = ThreadPriority.Highest;
            curThread.Name = "aaa";
        }

        private void Btn_StartThread_Click(object sender, EventArgs e)
        {
            threadFlag = true;
            curThread = new Thread(new ThreadStart(() => {  
                try
                { 
                    while (threadFlag)
                    {
                        Thread.Sleep(1000);
                        System.Diagnostics.Trace.WriteLine("count:" + count++);
                    }
                    System.Diagnostics.Trace.WriteLine("线程正常结束" );
                }
                catch(ThreadAbortException tae)
                {
                    System.Diagnostics.Trace.WriteLine("线程被终止:" + tae.Message );
                }
            }));
            curThread.Start();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            threadFlag = false;
        }

        private void Btn_Abort_Click(object sender, EventArgs e)
        {
            curThread.Abort();
        }

        private void Btn_StartThreadPara_Click(object sender, EventArgs e)
        {
            threadFlag = true;
            curThread = new Thread(new ParameterizedThreadStart((object para) =>
            {
                int paraInt = Convert.ToInt32(para);
                try
                {
                    while (threadFlag)
                    {
                        Thread.Sleep(1000);
                        System.Diagnostics.Trace.WriteLine("count:" + paraInt++);
                    }
                    System.Diagnostics.Trace.WriteLine("线程正常结束");
                }
                catch (ThreadAbortException tae)
                {
                    System.Diagnostics.Trace.WriteLine("线程被终止:" + tae.Message);
                }
            }));
            curThread.Start(100);
        }

        private void Btn_Join_Click(object sender, EventArgs e)
        {
            curThread = new Thread(new ParameterizedThreadStart((object para) =>
            {
                int paraInt = Convert.ToInt32(para);

                while (paraInt < 110)
                {
                    Thread.Sleep(1000);
                    System.Diagnostics.Trace.WriteLine("count:" + paraInt++);
                }
                System.Diagnostics.Trace.WriteLine("子线程正常结束");

            }));
            curThread.Start(100);
            System.Diagnostics.Trace.WriteLine("主线程等待");
            curThread.Join();
            System.Diagnostics.Trace.WriteLine("主线程继续");

        }

        private void Btn_Front_Click(object sender, EventArgs e)
        {
            threadFlag = true;
            System.Diagnostics.Trace.WriteLine("main thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
            curThread = new Thread(new ThreadStart(() =>
            {
                System.Diagnostics.Trace.WriteLine("ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
                try
                {
                    while (threadFlag)
                    {
                        Thread.Sleep(1000);
                        System.Diagnostics.Trace.WriteLine("count:" + count++);
                    }
                    System.Diagnostics.Trace.WriteLine("线程正常结束");
                }
                catch (ThreadAbortException tae)
                {
                    System.Diagnostics.Trace.WriteLine("线程被终止:" + tae.Message);
                }
            }));
            curThread.IsBackground = false;
            curThread.Start();
        }

        private void Btn_Background_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("main thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
          
            threadFlag = true;
            curThread = new Thread(new ThreadStart(() =>
            {
                System.Diagnostics.Trace.WriteLine("  thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
          
                try
                {
                    while (threadFlag)
                    {
                        Thread.Sleep(1000);
                        System.Diagnostics.Trace.WriteLine("count:" + count++);
                    }
                    System.Diagnostics.Trace.WriteLine("线程正常结束");
                }
                catch (ThreadAbortException tae)
                {
                    System.Diagnostics.Trace.WriteLine("线程被终止:" + tae.Message);
                }
            }));
            curThread.IsBackground = true;
            curThread.Start();
        }

        private void Btn_GetThreadPoolInfo_Click(object sender, EventArgs e)
        {
            int workerThreads =0;
            int completionPortThreads=0;
            
            ThreadPool.GetMaxThreads(out workerThreads,out completionPortThreads);

              Tb_ThreadInfo.Text = "workerThreads:  " + workerThreads + "   completionPortThreads" + completionPortThreads;
             
          
        }

        private void Btn_SetThreadPoolInfo_Click(object sender, EventArgs e)
        {
            ThreadPool.SetMaxThreads(100, 100);
       
        }

        private void ThreadPool_Start_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("main thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
          
            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) => {
                System.Diagnostics.Trace.WriteLine("  thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
          
                if(para == null)
                {
                    System.Diagnostics.Trace.WriteLine("para == null");
                }
                else 
                {
                    System.Diagnostics.Trace.WriteLine("para not null");
                }
            }));
        }

        private void ThreadPool_StartPara_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("main thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
          
            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                System.Diagnostics.Trace.WriteLine("  thread ManagedThreadId" + Thread.CurrentThread.ManagedThreadId);
          
                if (para == null)
                {
                    System.Diagnostics.Trace.WriteLine("para == null");
                }
                else
                {
                    System.Diagnostics.Trace.WriteLine(para.ToString());
                }
            }),2);
        }

        private void Btn_Normal_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            int conflictCount = 0;
            for(int i =0; i< 100; i++)
            {
                threadArray[i] =new Thread(new ThreadStart(() => {
                    for(int j = 0; j< 100;j++)
                    {
                     conflictCount++;
                     Thread.Sleep(10);
                    }

                })); 
                threadArray[i].Start();
            }

            for (int i = 0; i < 100; i++)
            {
                threadArray[i].Join();
            }
            System.Diagnostics.Trace.WriteLine("conflictCount:" + conflictCount);
           
        }


        private void AddConflictCount()
        {
          //  Interlocked.Increment(ref conflictCount);
        }

        private void Btn_Interlocked_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            int conflictCount = 0;
            for (int i = 0; i < 100; i++)
            {
                threadArray[i] = new Thread(new ThreadStart(() =>
                {
                    for (int j = 0; j < 100; j++)
                    {
                        Interlocked.Increment(ref conflictCount);
                        Thread.Sleep(10);
                    }

                }));
                threadArray[i].Start();
            }

            for (int i = 0; i < 100; i++)
            {
                threadArray[i].Join();
            }
            System.Diagnostics.Trace.WriteLine("conflictCount:" + conflictCount);
        }

        private void Btn_Lock_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            int conflictCount = 0;
            object conflictObj = new object ();
            for (int i = 0; i < 100; i++)
            {
                threadArray[i] = new Thread(new ThreadStart(() =>
                {
                    for (int j = 0; j < 100; j++)
                    {
                        lock (conflictObj)
                        {
                             conflictCount++;
                        }
                        Thread.Sleep(10);
                    }

                }));
                threadArray[i].Start();
            }

            for (int i = 0; i < 100; i++)
            {
                threadArray[i].Join();
            }
            System.Diagnostics.Trace.WriteLine("conflictCount:" + conflictCount);
        }

        private void Monitor_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            TestClass conflictClass = new TestClass();
            object conflictObj = new object();
            for (int i = 0; i < 100; i++)
            {
                try
                {
                    threadArray[i] = new Thread(new ThreadStart(() =>
                    {
                        try
                        {
                            for (int j = 0; j < 100; j++)
                            {
                                System.Threading.Monitor.Enter(conflictClass);
                                conflictClass.Count++;
                                System.Threading.Monitor.Exit(conflictClass);

                            }
                        }
                        catch
                        {
                            int a = 5;
                        }

                    }));
                }
                catch
                {
                    int a = 5;
                }
                threadArray[i].Start();
            }

            for (int i = 0; i < 100; i++)
            {
                threadArray[i].Join();
            }
            System.Diagnostics.Trace.WriteLine("conflictCount:" + conflictClass.Count);
        }

      
    }

    public class TestClass
    {
        public int Count { get; set; }
    }
}
