using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace _07_Other
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void UpdateText(string I_Text)
        {
            if(this.InvokeRequired)
            {
                System.Diagnostics.Trace.WriteLine("invoke Thread id:" + Thread.CurrentThread.ManagedThreadId);
                this.BeginInvoke(new Action<string>(UpdateText), new object[] { I_Text }) ; 
            }
            else
            {
                System.Diagnostics.Trace.WriteLine("after Thread id:" + Thread.CurrentThread.ManagedThreadId);
          
                Tb_Result.Text += I_Text + Environment.NewLine;
                
            }
        }

        private void Btn_BackThread_Click(object sender, EventArgs e)
        {
          //  Tb_Result.Text += "aa" + Environment.NewLine;

            System.Diagnostics.Trace.WriteLine("main Thread id:" + Thread.CurrentThread.ManagedThreadId);

            ThreadPool.QueueUserWorkItem(new WaitCallback((object para1) => {
                for (int i = 0; i < 10; i++)
                {
                    
                    ThreadPool.QueueUserWorkItem(new WaitCallback((object para) =>
                    { 
                        System.Diagnostics.Trace.WriteLine("InnerThread:" + Thread.CurrentThread.ManagedThreadId);
                         UpdateText("aa");

                        //   Tb_Result.Text += "aa" + Environment.NewLine;
                    }));
                }
            }));
       
        }

        private void Btn_BackgroudWorker_Click(object sender, EventArgs e)
        {
            BackgroundWorker bgw = new BackgroundWorker();
            bgw.WorkerReportsProgress = true;
            bgw.DoWork += bgw_DoWork;
            bgw.ProgressChanged += bgw_ProgressChanged;
            bgw.RunWorkerCompleted += bgw_RunWorkerCompleted;
            bgw.RunWorkerAsync();
        }

        void bgw_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("complete:" + Thread.CurrentThread.ManagedThreadId);
            Tb_Result.Text += "complete " ;
        }

        void bgw_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("progress:" + Thread.CurrentThread.ManagedThreadId);

            Tb_Result.Text += "percent: " + e.ProgressPercentage + " status: " + e.UserState.ToString() + Environment.NewLine;
        }

        void bgw_DoWork(object sender, DoWorkEventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("worker:" + Thread.CurrentThread.ManagedThreadId);

            BackgroundWorker curBgw = sender as BackgroundWorker;

            curBgw.ReportProgress(0, "aa");
            Thread.Sleep(1000);
            curBgw.ReportProgress(10, "bb");
            Thread.Sleep(1000);
            curBgw.ReportProgress(20, "cc");
            Thread.Sleep(1000);
            curBgw.ReportProgress(30, "dd"); 
                     
        }

        private void Btn_T_Timer_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("main thread id:" + Thread.CurrentThread.ManagedThreadId);

            System.Threading.Timer timerThr = new System.Threading.Timer(new TimerCallback((object para) => {
                System.Diagnostics.Trace.WriteLine("t_timer:" + Thread.CurrentThread.ManagedThreadId);

            }), null, Timeout.Infinite, 500);

            timerThr.Change(0, 500);

        }

        private void Btn_SystemTimer_Click(object sender, EventArgs e)
        {
            System.Timers.Timer timer = new System.Timers.Timer();
            System.Diagnostics.Trace.WriteLine("main thread id:" + Thread.CurrentThread.ManagedThreadId);

            timer.Enabled = true; 
            timer.Interval = 1000; 
            timer.AutoReset = true;

            timer.Elapsed += timer_Elapsed;
        }

        void timer_Elapsed(object sender, System.Timers.ElapsedEventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("s_timer:" + Thread.CurrentThread.ManagedThreadId);

        }

        private void Btn_Form_Timer_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("main thread id:" + Thread.CurrentThread.ManagedThreadId);

            System.Windows.Forms.Timer timer = new System.Windows.Forms.Timer();
            timer.Enabled = true;
            timer.Interval = 1000;
            timer.Tick += timer_Tick;

        }

        private void timer_Tick(object sender, EventArgs e)
        {
            System.Diagnostics.Trace.WriteLine("f_timer:" + Thread.CurrentThread.ManagedThreadId);
        }
    }
}
