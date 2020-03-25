namespace _01_Process
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.Tb_Info = new System.Windows.Forms.TextBox();
            this.Btn_AddThread = new System.Windows.Forms.Button();
            this.Btn_SetPriority = new System.Windows.Forms.Button();
            this.Btn_SetName = new System.Windows.Forms.Button();
            this.Btn_StartProcess = new System.Windows.Forms.Button();
            this.Btn_OutputInfo = new System.Windows.Forms.Button();
            this.Btn_CloseProcess = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Tb_Info
            // 
            this.Tb_Info.Location = new System.Drawing.Point(30, 118);
            this.Tb_Info.Multiline = true;
            this.Tb_Info.Name = "Tb_Info";
            this.Tb_Info.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Tb_Info.Size = new System.Drawing.Size(442, 127);
            this.Tb_Info.TabIndex = 1;
            // 
            // Btn_AddThread
            // 
            this.Btn_AddThread.Location = new System.Drawing.Point(179, 64);
            this.Btn_AddThread.Name = "Btn_AddThread";
            this.Btn_AddThread.Size = new System.Drawing.Size(129, 35);
            this.Btn_AddThread.TabIndex = 2;
            this.Btn_AddThread.Text = "添加线程到当前进程";
            this.Btn_AddThread.UseVisualStyleBackColor = true;
            this.Btn_AddThread.Click += new System.EventHandler(this.Btn_AddThread_Click);
            // 
            // Btn_SetPriority
            // 
            this.Btn_SetPriority.Location = new System.Drawing.Point(179, 23);
            this.Btn_SetPriority.Name = "Btn_SetPriority";
            this.Btn_SetPriority.Size = new System.Drawing.Size(129, 35);
            this.Btn_SetPriority.TabIndex = 3;
            this.Btn_SetPriority.Text = "设置优先级(high)";
            this.Btn_SetPriority.UseVisualStyleBackColor = true;
            this.Btn_SetPriority.Click += new System.EventHandler(this.Btn_SetPriority_Click);
            // 
            // Btn_SetName
            // 
            this.Btn_SetName.Location = new System.Drawing.Point(334, 23);
            this.Btn_SetName.Name = "Btn_SetName";
            this.Btn_SetName.Size = new System.Drawing.Size(129, 35);
            this.Btn_SetName.TabIndex = 4;
            this.Btn_SetName.Text = "设置优先级(Idle)";
            this.Btn_SetName.UseVisualStyleBackColor = true;
            this.Btn_SetName.Click += new System.EventHandler(this.Btn_SetPriority_Idle_Click);
            // 
            // Btn_StartProcess
            // 
            this.Btn_StartProcess.Location = new System.Drawing.Point(30, 64);
            this.Btn_StartProcess.Name = "Btn_StartProcess";
            this.Btn_StartProcess.Size = new System.Drawing.Size(129, 35);
            this.Btn_StartProcess.TabIndex = 5;
            this.Btn_StartProcess.Text = "带参数启动进程";
            this.Btn_StartProcess.UseVisualStyleBackColor = true;
            this.Btn_StartProcess.Click += new System.EventHandler(this.Btn_StartProcess_Click);
            // 
            // Btn_OutputInfo
            // 
            this.Btn_OutputInfo.Location = new System.Drawing.Point(30, 23);
            this.Btn_OutputInfo.Name = "Btn_OutputInfo";
            this.Btn_OutputInfo.Size = new System.Drawing.Size(129, 35);
            this.Btn_OutputInfo.TabIndex = 6;
            this.Btn_OutputInfo.Text = "输出当前进程信息";
            this.Btn_OutputInfo.UseVisualStyleBackColor = true;
            this.Btn_OutputInfo.Click += new System.EventHandler(this.Btn_OutputInfo_Click);
            // 
            // Btn_CloseProcess
            // 
            this.Btn_CloseProcess.Location = new System.Drawing.Point(334, 64);
            this.Btn_CloseProcess.Name = "Btn_CloseProcess";
            this.Btn_CloseProcess.Size = new System.Drawing.Size(129, 35);
            this.Btn_CloseProcess.TabIndex = 7;
            this.Btn_CloseProcess.Text = "强行结束进程";
            this.Btn_CloseProcess.UseVisualStyleBackColor = true;
            this.Btn_CloseProcess.Click += new System.EventHandler(this.Btn_CloseProcess_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(488, 273);
            this.Controls.Add(this.Btn_CloseProcess);
            this.Controls.Add(this.Btn_OutputInfo);
            this.Controls.Add(this.Btn_StartProcess);
            this.Controls.Add(this.Btn_SetName);
            this.Controls.Add(this.Btn_SetPriority);
            this.Controls.Add(this.Btn_AddThread);
            this.Controls.Add(this.Tb_Info);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox Tb_Info;
        private System.Windows.Forms.Button Btn_AddThread;
        private System.Windows.Forms.Button Btn_SetPriority;
        private System.Windows.Forms.Button Btn_SetName;
        private System.Windows.Forms.Button Btn_StartProcess;
        private System.Windows.Forms.Button Btn_OutputInfo;
        private System.Windows.Forms.Button Btn_CloseProcess;
    }
}

