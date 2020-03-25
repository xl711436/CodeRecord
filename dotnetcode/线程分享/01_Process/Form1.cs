using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace _01_Process
{
    public partial class Form1 : Form
    {
        private Process curProcess;
        public Form1()
        {
            InitializeComponent();
        }

        private void Btn_Process_Click(object sender, EventArgs e)
        {
              curProcess = Process.GetCurrentProcess();  
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private string GetProcessInfo(Process I_Process)
        {
            StringBuilder R_Result = new StringBuilder();

            R_Result.Append("BasePriority： " + I_Process.BasePriority + Environment.NewLine);

            if (I_Process.HasExited)
            {
                R_Result.Append("ExitTime： " + I_Process.ExitTime + Environment.NewLine);
            }
            R_Result.Append("Id： " + I_Process.Id + Environment.NewLine);
            R_Result.Append("MainModule.ModuleName： " + I_Process.MainModule.ModuleName + Environment.NewLine);
            R_Result.Append("MachineName： " + I_Process.MachineName + Environment.NewLine);
            R_Result.Append("MainWindowTitle： " + I_Process.MainWindowTitle + Environment.NewLine);
            R_Result.Append("ProcessName： " + I_Process.ProcessName + Environment.NewLine);
            R_Result.Append("StartTime： " + I_Process.StartTime + Environment.NewLine);
            R_Result.Append("Threads count： " + I_Process.Threads.Count + Environment.NewLine);
            R_Result.Append("TotalProcessorTime： " + I_Process.TotalProcessorTime + Environment.NewLine);
             
            return R_Result.ToString(); 
        }

        private void Btn_AddThread_Click(object sender, EventArgs e)
        {
            new Thread(new ThreadStart(() => { 
                Thread.Sleep(5000); 
            })).Start();
        }

        private void Btn_SetPriority_Click(object sender, EventArgs e)
        {
            curProcess.PriorityClass = ProcessPriorityClass.High;
        }

        private void Btn_SetPriority_Idle_Click(object sender, EventArgs e)
        {
            curProcess.PriorityClass = ProcessPriorityClass.Idle;
        }

        private void Btn_StartProcess_Click(object sender, EventArgs e)
        {
            curProcess = new Process();
            curProcess.StartInfo.Arguments = Path.Combine(System.Windows.Forms.Application.StartupPath, "1.txt");
            curProcess.StartInfo.FileName = @"C:\Windows\System32\notepad.exe";
            curProcess.Start();
        }

        private void Btn_OutputInfo_Click(object sender, EventArgs e)
        {
            curProcess = Process.GetCurrentProcess();  
            Tb_Info.Text = GetProcessInfo(curProcess); 
        }

        private void Btn_CloseProcess_Click(object sender, EventArgs e)
        {
            Process.GetCurrentProcess().Kill();
        }
    }
}
