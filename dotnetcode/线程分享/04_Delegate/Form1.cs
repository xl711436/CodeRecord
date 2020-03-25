using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace _04_Delegate
{
    delegate int MyDelegate(string name);

    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Btn_Start_Click(object sender, EventArgs e)
        {
            MyDelegate myDelegate = new MyDelegate((string para) =>
            {
                System.Diagnostics.Trace.WriteLine("delegate thread:" + Thread.CurrentThread.ManagedThreadId);
                Thread.Sleep(3000);
                return para.Length;

            });

            IAsyncResult result = myDelegate.BeginInvoke("Leslie", null, null);
            System.Diagnostics.Trace.WriteLine("start invoke");


            using (WebClient wc = new WebClient())
            {
                Tb_ThreadInfo.Text = wc.DownloadString(new Uri("http://www.cnblogs.com"));
                System.Diagnostics.Trace.WriteLine("download ok:" + Tb_ThreadInfo.Text.Length);
            }

            System.Diagnostics.Trace.WriteLine("main thread:" + Thread.CurrentThread.ManagedThreadId);
            int data = myDelegate.EndInvoke(result);

            System.Diagnostics.Trace.WriteLine("result:" + data.ToString());
        }

        private void Btn_PollWait_Click(object sender, EventArgs e)
        {

            List<string> webSites = new List<string>(){
            "http://www.cnblogs.com",
            "http://www.baidu.com",
              "http://www.csdn.com",
            "http://www.baidu.com",
             "http://www.cnblogs.com",
            "http://www.csdn.com",
             "http://www.cnblogs.com",
            "http://www.baidu.com",
             "http://www.csdn.com",
         
            };
            MyDelegate myDelegate = new MyDelegate((string para) =>
           {
               System.Diagnostics.Trace.WriteLine("delegate thread:" + Thread.CurrentThread.ManagedThreadId);
               Thread.Sleep(1000);
               return para.Length;
           });


            IAsyncResult result = myDelegate.BeginInvoke("Leslie", null, null);
            Tb_ThreadInfo.Text += "start invoke" + Environment.NewLine;

            foreach (string curWebsite in webSites)
            {
                using (WebClient wc = new WebClient())
                {
                    string curContent = wc.DownloadString(new Uri(curWebsite));
                    Thread.Sleep(1000);
                    Tb_ThreadInfo.Text += curWebsite + ": length:" + curContent.Length.ToString() + Environment.NewLine;
                }

                if (result.IsCompleted)
                {
                    break;
                }
            }

            int data = myDelegate.EndInvoke(result);
            System.Diagnostics.Trace.WriteLine("main thread:" + Thread.CurrentThread.ManagedThreadId);
            Tb_ThreadInfo.Text += ("result:" + data.ToString());

        }

        private void Btn_PollWait_Multy_Click(object sender, EventArgs e)
        {
            List<string> webSites = new List<string>(){
            "http://www.cnblogs.com",
            "http://www.baidu.com",
              "http://www.csdn.com",
            "http://www.baidu.com",
             "http://www.cnblogs.com",
            "http://www.csdn.com",
             "http://www.cnblogs.com",
            "http://www.baidu.com",
             "http://www.csdn.com",
         
            };
            List<MyDelegate> delegateList = new List<MyDelegate>() { 
                new MyDelegate((string para) =>
                {
                    System.Diagnostics.Trace.WriteLine("delegate1 thread:" + Thread.CurrentThread.ManagedThreadId);
                    Thread.Sleep(3000);
                    return para.Length;
                }),
                new MyDelegate((string para) =>
                {
                    System.Diagnostics.Trace.WriteLine("delegate2 thread:" + Thread.CurrentThread.ManagedThreadId);
                    Thread.Sleep(6000);
                    return para.Length;
                }),
                new MyDelegate((string para) =>
                {
                    System.Diagnostics.Trace.WriteLine("delegate3 thread:" + Thread.CurrentThread.ManagedThreadId);
                    Thread.Sleep(4000);
                    return para.Length;
                }),
             
            };

            List<IAsyncResult> resultList = new List<IAsyncResult>() { 
                delegateList[0].BeginInvoke("Leslie", null, null),
                delegateList[1].BeginInvoke("jackson", null, null),
                delegateList[2].BeginInvoke("Mike", null, null) 
            };

            WaitHandle[] handleList = resultList.Select(p => p.AsyncWaitHandle).ToArray();

            foreach (string curWebsite in webSites)
            {
                using (WebClient wc = new WebClient())
                {
                    string curContent = wc.DownloadString(new Uri(curWebsite));
                    Thread.Sleep(1000);
                    Tb_ThreadInfo.Text += curWebsite + ": length:" + curContent.Length.ToString() + Environment.NewLine;
                }

                if (WaitHandle.WaitAll(handleList, 100))
                {
                    System.Diagnostics.Trace.WriteLine("main thread:" + Thread.CurrentThread.ManagedThreadId);
                    break;
                }
            }

            for (int i = 0; i < delegateList.Count; i++)
            {
                int data = delegateList[i].EndInvoke(resultList[i]);
                Tb_ThreadInfo.Text += ("result:" + data.ToString() + Environment.NewLine);
            }

        }

        private void Btn_CallBack_Click(object sender, EventArgs e)
        {
            MyDelegate myDelegate = new MyDelegate((string para) =>
            {
                System.Diagnostics.Trace.WriteLine("delegate thread:" + Thread.CurrentThread.ManagedThreadId);
                Thread.Sleep(3000);
                return para.Length;
            });

            myDelegate.BeginInvoke("Leslie", new AsyncCallback((IAsyncResult result) =>
            {

                MyDelegate curDelegate = (MyDelegate)((AsyncResult)result).AsyncDelegate;
                int data = curDelegate.EndInvoke(result);
                System.Diagnostics.Trace.WriteLine("call back thread:" + Thread.CurrentThread.ManagedThreadId);

                System.Diagnostics.Trace.WriteLine("result:" + data);

            }), null);

            System.Diagnostics.Trace.WriteLine("main thread:" + Thread.CurrentThread.ManagedThreadId);
        }

        private void Btn_CallBack_Multy_Click(object sender, EventArgs e)
        {
            List<MyDelegate> delegateList = new List<MyDelegate>() { 
                new MyDelegate((string para) =>
                {
                    System.Diagnostics.Trace.WriteLine("delegate1 thread:" + Thread.CurrentThread.ManagedThreadId);
                    Thread.Sleep(3000);
                    return para.Length;
                }),
                new MyDelegate((string para) =>
                {
                    System.Diagnostics.Trace.WriteLine("delegate2 thread:" + Thread.CurrentThread.ManagedThreadId);
                    Thread.Sleep(6000);
                    return para.Length;
                }),
                new MyDelegate((string para) =>
                {
                    System.Diagnostics.Trace.WriteLine("delegate3 thread:" + Thread.CurrentThread.ManagedThreadId);
                    Thread.Sleep(4000);
                    return para.Length;
                }),
             
            };


            List<string> parList = new List<string>() { "Leslie" ,"jackson","mike"};
         

            for (int i = 0; i < delegateList.Count; i++)
            {
                delegateList[i].BeginInvoke("Leslie", new AsyncCallback((IAsyncResult result) =>
                {
                    MyDelegate curDelegate = (MyDelegate)((AsyncResult)result).AsyncDelegate;
                    int data = curDelegate.EndInvoke(result);
                    System.Diagnostics.Trace.WriteLine("call back thread:" + Thread.CurrentThread.ManagedThreadId);

                     
                    System.Diagnostics.Trace.WriteLine("result:" + data);

                }), null);
            }



            System.Diagnostics.Trace.WriteLine("main thread:" + Thread.CurrentThread.ManagedThreadId);
        }


    }
}
