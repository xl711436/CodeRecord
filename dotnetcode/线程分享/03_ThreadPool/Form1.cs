using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace _03_ThreadPool
{
    public partial class Form1 : Form
    {
        private Thread curThread;

        private bool threadFlag;

        private int count = 0;
        private int readWriteCount = 0;

        private Mutex globeMutex = new Mutex(false, "globeMutex");
        private Semaphore globeSemaphore = new Semaphore(0, 2, "globeSemaphore");
        private ReaderWriterLockSlim rwLock = new ReaderWriterLockSlim();

        private AutoResetEvent autoEvent = new AutoResetEvent(false);
        private ManualResetEvent manualEvent = new ManualResetEvent(false);
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
            curThread.Priority = ThreadPriority.Highest;
            curThread.Name = "aaa";
        }

        private void Btn_StartThread_Click(object sender, EventArgs e)
        {
            threadFlag = true;
            curThread = new Thread(new ThreadStart(() =>
            {
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
                System.Diagnostics.Trace.WriteLine("线程正常结束");

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

        private void Btn_ThreadPool_Click(object sender, EventArgs e)
        {
            int workerThreads = 0;
            int completionPortThreads = 0;

            ThreadPool.GetMaxThreads(out workerThreads, out completionPortThreads);

            System.Diagnostics.Trace.WriteLine("workerThreads:" + workerThreads + "completionPortThreads" + completionPortThreads);

            ThreadPool.SetMaxThreads(100, 100);
            ThreadPool.GetMaxThreads(out workerThreads, out completionPortThreads);

            System.Diagnostics.Trace.WriteLine("workerThreads:" + workerThreads + "completionPortThreads" + completionPortThreads);

        }

        private void ThreadPool_Start_Click(object sender, EventArgs e)
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
            }), 2);
        }

        private void Btn_Normal_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            int conflictCount = 0;

            for (int i = 0; i < 100; i++)
            {
                threadArray[i] = new Thread(new ThreadStart(() =>
                {
                    for (int j = 0; j < 100; j++)
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
            MessageBox.Show("conflictCount:" + conflictCount);  
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
            object conflictObj = new object();
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
            MessageBox.Show("conflictCount:" + conflictCount);
        }

        private void Monitor_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            int conflictCount = 0;
            object conflictObj = new object();

            for (int i = 0; i < 100; i++)
            { 
                threadArray[i] = new Thread(new ThreadStart(() =>
                {
                    for (int j = 0; j < 100; j++)
                    {
                        try
                        {
                            System.Threading.Monitor.Enter(conflictObj);
                            conflictCount++; 
                        }
                        finally
                        {
                            System.Threading.Monitor.Exit(conflictObj);
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
           MessageBox.Show("conflictCount:" + conflictCount);
        }

        private void Btn_LocalMutex_Click(object sender, EventArgs e)
        {
            Thread[] threadArray = new Thread[100];
            int conflictCount = 0;
            Mutex mut = new Mutex();

            for (int i = 0; i < 100; i++)
            {
                threadArray[i] = new Thread(new ThreadStart(() =>
                {
                    for (int j = 0; j < 100; j++)
                    {
                        try
                        {
                            mut.WaitOne();
                            conflictCount++;
                        }
                        finally
                        {
                            mut.ReleaseMutex();
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
            MessageBox.Show("conflictCount:" + conflictCount);
        }

        private void Btn_GlobeMutex_Enter_Click(object sender, EventArgs e)
        {
            globeMutex.WaitOne();

            MessageBox.Show(Process.GetCurrentProcess().Id+ "获取全局mutex");
        }

        private void Btn_GlobeMutex_Exit_Click(object sender, EventArgs e)
        {
            globeMutex.ReleaseMutex();
            MessageBox.Show(Process.GetCurrentProcess().Id + "释放全局mutex");
        }

        private void Btn_GlobeSemaphore_Enter_Click(object sender, EventArgs e)
        {
            globeSemaphore.WaitOne();
            MessageBox.Show(Process.GetCurrentProcess().Id + "获取全局Semaphore");
        }

        private void Btn_GlobeSemaphore_Exit_Click(object sender, EventArgs e)
        {
            globeSemaphore.Release();
            MessageBox.Show(Process.GetCurrentProcess().Id + "释放全局Semaphore");
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            globeSemaphore.Release(2);
            MessageBox.Show( "初始化全局Semaphore为2");
        }

        private void Btn_Read_Click(object sender, EventArgs e)
        {

            Thread[] threadArray = new Thread[100];
          
          

            for (int i = 0; i < 100; i++)
            {
                threadArray[i] = new Thread(new ParameterizedThreadStart((object index) =>
                {
                    for (int j = 0; j < 100; j++)
                    {
                        rwLock.EnterReadLock();
                        System.Diagnostics.Trace.WriteLine("读线程数：" + readWriteCount);
                        Interlocked.Increment(ref readWriteCount);
                        Thread.Sleep(100);
                        Interlocked.Decrement(ref readWriteCount);
                        rwLock.ExitReadLock();
                        
                    }
                }));
                threadArray[i].Start(i);
            }
             
        }
 

        private void Btn_Write_Click(object sender, EventArgs e)
        {
            rwLock.EnterWriteLock();
         
            Thread.Sleep(100);
            System.Diagnostics.Trace.WriteLine("开始写入，读线程数：" + readWriteCount);
            rwLock.ExitWriteLock();
           
        }

        private void Btn_AutoResetEvent_Set_Click(object sender, EventArgs e)
        {
            new Thread(new ThreadStart(() =>
            {
                System.Diagnostics.Trace.WriteLine("AutoResetEvent.Set start  ");
                autoEvent.Set();
                System.Diagnostics.Trace.WriteLine("AutoResetEvent.Set end  ");
            })).Start();

        }

        private void Btn_AutoResetEvent_Wait_Click(object sender, EventArgs e)
        {
            new Thread(new ThreadStart(() => {
                System.Diagnostics.Trace.WriteLine("AutoResetEvent.WaitOne  start ");
                autoEvent.WaitOne();
                System.Diagnostics.Trace.WriteLine("AutoResetEvent.WaitOne end  ");
            })).Start();
           
        }

        private void Btn_ManueResetEvent_Set_Click(object sender, EventArgs e)
        {
               new Thread(new ThreadStart(() =>
            {
                System.Diagnostics.Trace.WriteLine("ManualResetEvent.Set start  ");
                manualEvent.Set();
                System.Diagnostics.Trace.WriteLine("ManualResetEvent.Set end  ");
            })).Start();
          
        }

        private void Btn_ManualResetEvent_Wait_Click(object sender, EventArgs e)
        {
            new Thread(new ThreadStart(() =>
            {
                System.Diagnostics.Trace.WriteLine("ManualResetEvent.WaitOne  start ");
                manualEvent.WaitOne();
             //   manualEvent.Reset();
                System.Diagnostics.Trace.WriteLine("ManualResetEvent.WaitOne end  ");
            })).Start();
        }

        private void Btn_WaitAny_Click(object sender, EventArgs e)
        {
            WaitHandle[] handle = new WaitHandle[] { 
                new AutoResetEvent(false),
                new AutoResetEvent(false)
            };

            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                Thread.Sleep(3000); 
                AutoResetEvent curHandle = (AutoResetEvent)para; 
                curHandle.Set();
                System.Diagnostics.Trace.WriteLine("first Thread ok  ");
            }), handle[0]);
             
            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                Thread.Sleep(6000); 
                AutoResetEvent curHandle = (AutoResetEvent)para;
                curHandle.Set();
                System.Diagnostics.Trace.WriteLine("second Thread ok  ");
            }), handle[1]);

            System.Diagnostics.Trace.WriteLine("WaitAny start  ");
            WaitHandle.WaitAny(handle);
            System.Diagnostics.Trace.WriteLine("WaitAny end  "); 
        }

        private void Btn_WaitAll_Click(object sender, EventArgs e)
        {
            WaitHandle[] handle = new WaitHandle[] { 
                new AutoResetEvent(false),
                new AutoResetEvent(false)
            };

            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                Thread.Sleep(3000);
                AutoResetEvent curHandle = (AutoResetEvent)para;
                curHandle.Set();
                System.Diagnostics.Trace.WriteLine("first Thread ok  ");
            }), handle[0]);

            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                Thread.Sleep(6000);
                AutoResetEvent curHandle = (AutoResetEvent)para;
                curHandle.Set();
                System.Diagnostics.Trace.WriteLine("second Thread ok  ");
            }), handle[1]);

            System.Diagnostics.Trace.WriteLine("WaitAll start  ");
            WaitHandle.WaitAll(handle);
            System.Diagnostics.Trace.WriteLine("WaitAll end  "); 
        }

        private void Btn_DeadLock1_Click(object sender, EventArgs e)
        {
            AutoResetEvent resource1 = new AutoResetEvent(true);
            AutoResetEvent resource2 = new AutoResetEvent(true);

            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                System.Diagnostics.Trace.WriteLine("thread2 start  "); 
                resource1.WaitOne();
                System.Diagnostics.Trace.WriteLine("get resource1 ok  ");
                Thread.Sleep(3000); 
                resource2.WaitOne(); 
                System.Diagnostics.Trace.WriteLine("thread1 end  ");  
            }), null);

            ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
            {
                System.Diagnostics.Trace.WriteLine("thread2 start  ");
                resource2.WaitOne();
                System.Diagnostics.Trace.WriteLine("get resource2 ok  ");
                Thread.Sleep(3000);
                resource1.WaitOne(); 
                System.Diagnostics.Trace.WriteLine("thread2 end  "); 
            }), null);

        }
 
 

    
    }

    public class TestClass
    {
        public int Count { get; set; }
    }
}
