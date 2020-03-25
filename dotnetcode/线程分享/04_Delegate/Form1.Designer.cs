namespace _04_Delegate
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
            this.Btn_Start = new System.Windows.Forms.Button();
            this.Tb_ThreadInfo = new System.Windows.Forms.TextBox();
            this.Btn_PollWait = new System.Windows.Forms.Button();
            this.Btn_PollWait_Multy = new System.Windows.Forms.Button();
            this.Btn_CallBack = new System.Windows.Forms.Button();
            this.Btn_CallBack_Multy = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Btn_Start
            // 
            this.Btn_Start.Location = new System.Drawing.Point(12, 24);
            this.Btn_Start.Name = "Btn_Start";
            this.Btn_Start.Size = new System.Drawing.Size(102, 30);
            this.Btn_Start.TabIndex = 0;
            this.Btn_Start.Text = "执行异步委托";
            this.Btn_Start.UseVisualStyleBackColor = true;
            this.Btn_Start.Click += new System.EventHandler(this.Btn_Start_Click);
            // 
            // Tb_ThreadInfo
            // 
            this.Tb_ThreadInfo.Location = new System.Drawing.Point(12, 102);
            this.Tb_ThreadInfo.Multiline = true;
            this.Tb_ThreadInfo.Name = "Tb_ThreadInfo";
            this.Tb_ThreadInfo.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Tb_ThreadInfo.Size = new System.Drawing.Size(433, 185);
            this.Tb_ThreadInfo.TabIndex = 2;
            // 
            // Btn_PollWait
            // 
            this.Btn_PollWait.Location = new System.Drawing.Point(155, 24);
            this.Btn_PollWait.Name = "Btn_PollWait";
            this.Btn_PollWait.Size = new System.Drawing.Size(109, 30);
            this.Btn_PollWait.TabIndex = 3;
            this.Btn_PollWait.Text = "单委托轮询等待";
            this.Btn_PollWait.UseVisualStyleBackColor = true;
            this.Btn_PollWait.Click += new System.EventHandler(this.Btn_PollWait_Click);
            // 
            // Btn_PollWait_Multy
            // 
            this.Btn_PollWait_Multy.Location = new System.Drawing.Point(295, 24);
            this.Btn_PollWait_Multy.Name = "Btn_PollWait_Multy";
            this.Btn_PollWait_Multy.Size = new System.Drawing.Size(109, 30);
            this.Btn_PollWait_Multy.TabIndex = 4;
            this.Btn_PollWait_Multy.Text = "多委托轮询等待";
            this.Btn_PollWait_Multy.UseVisualStyleBackColor = true;
            this.Btn_PollWait_Multy.Click += new System.EventHandler(this.Btn_PollWait_Multy_Click);
            // 
            // Btn_CallBack
            // 
            this.Btn_CallBack.Location = new System.Drawing.Point(12, 66);
            this.Btn_CallBack.Name = "Btn_CallBack";
            this.Btn_CallBack.Size = new System.Drawing.Size(102, 30);
            this.Btn_CallBack.TabIndex = 5;
            this.Btn_CallBack.Text = "委托回调";
            this.Btn_CallBack.UseVisualStyleBackColor = true;
            this.Btn_CallBack.Click += new System.EventHandler(this.Btn_CallBack_Click);
            // 
            // Btn_CallBack_Multy
            // 
            this.Btn_CallBack_Multy.Location = new System.Drawing.Point(162, 66);
            this.Btn_CallBack_Multy.Name = "Btn_CallBack_Multy";
            this.Btn_CallBack_Multy.Size = new System.Drawing.Size(102, 30);
            this.Btn_CallBack_Multy.TabIndex = 6;
            this.Btn_CallBack_Multy.Text = "多委托回调";
            this.Btn_CallBack_Multy.UseVisualStyleBackColor = true;
            this.Btn_CallBack_Multy.Click += new System.EventHandler(this.Btn_CallBack_Multy_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(521, 329);
            this.Controls.Add(this.Btn_CallBack_Multy);
            this.Controls.Add(this.Btn_CallBack);
            this.Controls.Add(this.Btn_PollWait_Multy);
            this.Controls.Add(this.Btn_PollWait);
            this.Controls.Add(this.Tb_ThreadInfo);
            this.Controls.Add(this.Btn_Start);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Btn_Start;
        private System.Windows.Forms.TextBox Tb_ThreadInfo;
        private System.Windows.Forms.Button Btn_PollWait;
        private System.Windows.Forms.Button Btn_PollWait_Multy;
        private System.Windows.Forms.Button Btn_CallBack;
        private System.Windows.Forms.Button Btn_CallBack_Multy;
    }
}

