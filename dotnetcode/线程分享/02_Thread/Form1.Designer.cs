namespace _02_Thread_ThreadPool
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
            this.Btn_ThreadInfo = new System.Windows.Forms.Button();
            this.Tb_ThreadInfo = new System.Windows.Forms.TextBox();
            this.Btn_SetThread = new System.Windows.Forms.Button();
            this.Btn_StartThread = new System.Windows.Forms.Button();
            this.Btn_StartThreadPara = new System.Windows.Forms.Button();
            this.Btn_Abort = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.Btn_Join = new System.Windows.Forms.Button();
            this.Btn_Front = new System.Windows.Forms.Button();
            this.Btn_Background = new System.Windows.Forms.Button();
            this.Btn_GetThreadPoolInfo = new System.Windows.Forms.Button();
            this.ThreadPool_Start = new System.Windows.Forms.Button();
            this.ThreadPool_StartPara = new System.Windows.Forms.Button();
            this.Btn_SetThreadPoolInfo = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Btn_ThreadInfo
            // 
            this.Btn_ThreadInfo.Location = new System.Drawing.Point(27, 12);
            this.Btn_ThreadInfo.Name = "Btn_ThreadInfo";
            this.Btn_ThreadInfo.Size = new System.Drawing.Size(114, 28);
            this.Btn_ThreadInfo.TabIndex = 0;
            this.Btn_ThreadInfo.Text = "显示当前线程信息";
            this.Btn_ThreadInfo.UseVisualStyleBackColor = true;
            this.Btn_ThreadInfo.Click += new System.EventHandler(this.Btn_ThreadInfo_Click);
            // 
            // Tb_ThreadInfo
            // 
            this.Tb_ThreadInfo.Location = new System.Drawing.Point(27, 114);
            this.Tb_ThreadInfo.Multiline = true;
            this.Tb_ThreadInfo.Name = "Tb_ThreadInfo";
            this.Tb_ThreadInfo.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Tb_ThreadInfo.Size = new System.Drawing.Size(433, 96);
            this.Tb_ThreadInfo.TabIndex = 1;
            // 
            // Btn_SetThread
            // 
            this.Btn_SetThread.Location = new System.Drawing.Point(156, 12);
            this.Btn_SetThread.Name = "Btn_SetThread";
            this.Btn_SetThread.Size = new System.Drawing.Size(86, 28);
            this.Btn_SetThread.TabIndex = 2;
            this.Btn_SetThread.Text = "设置线程属性";
            this.Btn_SetThread.UseVisualStyleBackColor = true;
            this.Btn_SetThread.Click += new System.EventHandler(this.Btn_SetThread_Click);
            // 
            // Btn_StartThread
            // 
            this.Btn_StartThread.Location = new System.Drawing.Point(27, 46);
            this.Btn_StartThread.Name = "Btn_StartThread";
            this.Btn_StartThread.Size = new System.Drawing.Size(88, 28);
            this.Btn_StartThread.TabIndex = 3;
            this.Btn_StartThread.Text = "Start线程";
            this.Btn_StartThread.UseVisualStyleBackColor = true;
            this.Btn_StartThread.Click += new System.EventHandler(this.Btn_StartThread_Click);
            // 
            // Btn_StartThreadPara
            // 
            this.Btn_StartThreadPara.Location = new System.Drawing.Point(134, 46);
            this.Btn_StartThreadPara.Name = "Btn_StartThreadPara";
            this.Btn_StartThreadPara.Size = new System.Drawing.Size(127, 28);
            this.Btn_StartThreadPara.TabIndex = 4;
            this.Btn_StartThreadPara.Text = "Start线程（参数）";
            this.Btn_StartThreadPara.UseVisualStyleBackColor = true;
            this.Btn_StartThreadPara.Click += new System.EventHandler(this.Btn_StartThreadPara_Click);
            // 
            // Btn_Abort
            // 
            this.Btn_Abort.Location = new System.Drawing.Point(134, 80);
            this.Btn_Abort.Name = "Btn_Abort";
            this.Btn_Abort.Size = new System.Drawing.Size(74, 28);
            this.Btn_Abort.TabIndex = 5;
            this.Btn_Abort.Text = "Abort线程";
            this.Btn_Abort.UseVisualStyleBackColor = true;
            this.Btn_Abort.Click += new System.EventHandler(this.Btn_Abort_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(27, 80);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(88, 28);
            this.button1.TabIndex = 6;
            this.button1.Text = "正常结束线程";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Btn_Join
            // 
            this.Btn_Join.Location = new System.Drawing.Point(214, 80);
            this.Btn_Join.Name = "Btn_Join";
            this.Btn_Join.Size = new System.Drawing.Size(74, 28);
            this.Btn_Join.TabIndex = 7;
            this.Btn_Join.Text = "Join线程";
            this.Btn_Join.UseVisualStyleBackColor = true;
            this.Btn_Join.Click += new System.EventHandler(this.Btn_Join_Click);
            // 
            // Btn_Front
            // 
            this.Btn_Front.Location = new System.Drawing.Point(306, 80);
            this.Btn_Front.Name = "Btn_Front";
            this.Btn_Front.Size = new System.Drawing.Size(74, 28);
            this.Btn_Front.TabIndex = 8;
            this.Btn_Front.Text = "前台线程";
            this.Btn_Front.UseVisualStyleBackColor = true;
            this.Btn_Front.Click += new System.EventHandler(this.Btn_Front_Click);
            // 
            // Btn_Background
            // 
            this.Btn_Background.Location = new System.Drawing.Point(386, 80);
            this.Btn_Background.Name = "Btn_Background";
            this.Btn_Background.Size = new System.Drawing.Size(74, 28);
            this.Btn_Background.TabIndex = 9;
            this.Btn_Background.Text = "后台线程";
            this.Btn_Background.UseVisualStyleBackColor = true;
            this.Btn_Background.Click += new System.EventHandler(this.Btn_Background_Click);
            // 
            // Btn_GetThreadPoolInfo
            // 
            this.Btn_GetThreadPoolInfo.Location = new System.Drawing.Point(27, 216);
            this.Btn_GetThreadPoolInfo.Name = "Btn_GetThreadPoolInfo";
            this.Btn_GetThreadPoolInfo.Size = new System.Drawing.Size(103, 28);
            this.Btn_GetThreadPoolInfo.TabIndex = 10;
            this.Btn_GetThreadPoolInfo.Text = "获取线程池信息";
            this.Btn_GetThreadPoolInfo.UseVisualStyleBackColor = true;
            this.Btn_GetThreadPoolInfo.Click += new System.EventHandler(this.Btn_GetThreadPoolInfo_Click);
            // 
            // ThreadPool_Start
            // 
            this.ThreadPool_Start.Location = new System.Drawing.Point(259, 216);
            this.ThreadPool_Start.Name = "ThreadPool_Start";
            this.ThreadPool_Start.Size = new System.Drawing.Size(74, 28);
            this.ThreadPool_Start.TabIndex = 11;
            this.ThreadPool_Start.Text = "线程池启动";
            this.ThreadPool_Start.UseVisualStyleBackColor = true;
            this.ThreadPool_Start.Click += new System.EventHandler(this.ThreadPool_Start_Click);
            // 
            // ThreadPool_StartPara
            // 
            this.ThreadPool_StartPara.Location = new System.Drawing.Point(351, 216);
            this.ThreadPool_StartPara.Name = "ThreadPool_StartPara";
            this.ThreadPool_StartPara.Size = new System.Drawing.Size(109, 28);
            this.ThreadPool_StartPara.TabIndex = 12;
            this.ThreadPool_StartPara.Text = "线程池启动_参数";
            this.ThreadPool_StartPara.UseVisualStyleBackColor = true;
            this.ThreadPool_StartPara.Click += new System.EventHandler(this.ThreadPool_StartPara_Click);
            // 
            // Btn_SetThreadPoolInfo
            // 
            this.Btn_SetThreadPoolInfo.Location = new System.Drawing.Point(136, 216);
            this.Btn_SetThreadPoolInfo.Name = "Btn_SetThreadPoolInfo";
            this.Btn_SetThreadPoolInfo.Size = new System.Drawing.Size(103, 28);
            this.Btn_SetThreadPoolInfo.TabIndex = 13;
            this.Btn_SetThreadPoolInfo.Text = "获取线程池信息";
            this.Btn_SetThreadPoolInfo.UseVisualStyleBackColor = true;
            this.Btn_SetThreadPoolInfo.Click += new System.EventHandler(this.Btn_SetThreadPoolInfo_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(472, 259);
            this.Controls.Add(this.Btn_SetThreadPoolInfo);
            this.Controls.Add(this.ThreadPool_StartPara);
            this.Controls.Add(this.ThreadPool_Start);
            this.Controls.Add(this.Btn_GetThreadPoolInfo);
            this.Controls.Add(this.Btn_Background);
            this.Controls.Add(this.Btn_Front);
            this.Controls.Add(this.Btn_Join);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.Btn_Abort);
            this.Controls.Add(this.Btn_StartThreadPara);
            this.Controls.Add(this.Btn_StartThread);
            this.Controls.Add(this.Btn_SetThread);
            this.Controls.Add(this.Tb_ThreadInfo);
            this.Controls.Add(this.Btn_ThreadInfo);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Btn_ThreadInfo;
        private System.Windows.Forms.TextBox Tb_ThreadInfo;
        private System.Windows.Forms.Button Btn_SetThread;
        private System.Windows.Forms.Button Btn_StartThread;
        private System.Windows.Forms.Button Btn_StartThreadPara;
        private System.Windows.Forms.Button Btn_Abort;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button Btn_Join;
        private System.Windows.Forms.Button Btn_Front;
        private System.Windows.Forms.Button Btn_Background;
        private System.Windows.Forms.Button Btn_GetThreadPoolInfo;
        private System.Windows.Forms.Button ThreadPool_Start;
        private System.Windows.Forms.Button ThreadPool_StartPara;
        private System.Windows.Forms.Button Btn_SetThreadPoolInfo;
    }
}

