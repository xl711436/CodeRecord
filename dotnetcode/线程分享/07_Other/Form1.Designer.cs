namespace _07_Other
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
            this.Tb_Result = new System.Windows.Forms.TextBox();
            this.Btn_BackThread = new System.Windows.Forms.Button();
            this.Btn_BackgroudWorker = new System.Windows.Forms.Button();
            this.Btn_T_Timer = new System.Windows.Forms.Button();
            this.Btn_SystemTimer = new System.Windows.Forms.Button();
            this.Btn_Form_Timer = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Tb_Result
            // 
            this.Tb_Result.Location = new System.Drawing.Point(12, 119);
            this.Tb_Result.Multiline = true;
            this.Tb_Result.Name = "Tb_Result";
            this.Tb_Result.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Tb_Result.Size = new System.Drawing.Size(365, 94);
            this.Tb_Result.TabIndex = 0;
            // 
            // Btn_BackThread
            // 
            this.Btn_BackThread.Location = new System.Drawing.Point(23, 12);
            this.Btn_BackThread.Name = "Btn_BackThread";
            this.Btn_BackThread.Size = new System.Drawing.Size(139, 28);
            this.Btn_BackThread.TabIndex = 1;
            this.Btn_BackThread.Text = "后台线程控制界面元素";
            this.Btn_BackThread.UseVisualStyleBackColor = true;
            this.Btn_BackThread.Click += new System.EventHandler(this.Btn_BackThread_Click);
            // 
            // Btn_BackgroudWorker
            // 
            this.Btn_BackgroudWorker.Location = new System.Drawing.Point(213, 12);
            this.Btn_BackgroudWorker.Name = "Btn_BackgroudWorker";
            this.Btn_BackgroudWorker.Size = new System.Drawing.Size(139, 28);
            this.Btn_BackgroudWorker.TabIndex = 2;
            this.Btn_BackgroudWorker.Text = "BackgroudWorker";
            this.Btn_BackgroudWorker.UseVisualStyleBackColor = true;
            this.Btn_BackgroudWorker.Click += new System.EventHandler(this.Btn_BackgroudWorker_Click);
            // 
            // Btn_T_Timer
            // 
            this.Btn_T_Timer.Location = new System.Drawing.Point(23, 70);
            this.Btn_T_Timer.Name = "Btn_T_Timer";
            this.Btn_T_Timer.Size = new System.Drawing.Size(119, 28);
            this.Btn_T_Timer.TabIndex = 3;
            this.Btn_T_Timer.Text = "Thread Timer";
            this.Btn_T_Timer.UseVisualStyleBackColor = true;
            this.Btn_T_Timer.Click += new System.EventHandler(this.Btn_T_Timer_Click);
            // 
            // Btn_SystemTimer
            // 
            this.Btn_SystemTimer.Location = new System.Drawing.Point(148, 70);
            this.Btn_SystemTimer.Name = "Btn_SystemTimer";
            this.Btn_SystemTimer.Size = new System.Drawing.Size(119, 28);
            this.Btn_SystemTimer.TabIndex = 4;
            this.Btn_SystemTimer.Text = "System Timer";
            this.Btn_SystemTimer.UseVisualStyleBackColor = true;
            this.Btn_SystemTimer.Click += new System.EventHandler(this.Btn_SystemTimer_Click);
            // 
            // Btn_Form_Timer
            // 
            this.Btn_Form_Timer.Location = new System.Drawing.Point(284, 70);
            this.Btn_Form_Timer.Name = "Btn_Form_Timer";
            this.Btn_Form_Timer.Size = new System.Drawing.Size(93, 28);
            this.Btn_Form_Timer.TabIndex = 5;
            this.Btn_Form_Timer.Text = "Form Timer";
            this.Btn_Form_Timer.UseVisualStyleBackColor = true;
            this.Btn_Form_Timer.Click += new System.EventHandler(this.Btn_Form_Timer_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(397, 274);
            this.Controls.Add(this.Btn_Form_Timer);
            this.Controls.Add(this.Btn_SystemTimer);
            this.Controls.Add(this.Btn_T_Timer);
            this.Controls.Add(this.Btn_BackgroudWorker);
            this.Controls.Add(this.Btn_BackThread);
            this.Controls.Add(this.Tb_Result);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox Tb_Result;
        private System.Windows.Forms.Button Btn_BackThread;
        private System.Windows.Forms.Button Btn_BackgroudWorker;
        private System.Windows.Forms.Button Btn_T_Timer;
        private System.Windows.Forms.Button Btn_SystemTimer;
        private System.Windows.Forms.Button Btn_Form_Timer;
    }
}

