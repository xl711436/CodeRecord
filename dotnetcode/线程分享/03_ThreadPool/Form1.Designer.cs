namespace _03_ThreadPool
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
            this.Monitor = new System.Windows.Forms.Button();
            this.Btn_Lock = new System.Windows.Forms.Button();
            this.Btn_Interlocked = new System.Windows.Forms.Button();
            this.Btn_Normal = new System.Windows.Forms.Button();
            this.Tb_ThreadInfo = new System.Windows.Forms.TextBox();
            this.Btn_LocalMutex = new System.Windows.Forms.Button();
            this.Btn_GlobeMutex_Enter = new System.Windows.Forms.Button();
            this.Btn_GlobeMutex_Exit = new System.Windows.Forms.Button();
            this.Btn_GlobeSemaphore_Enter = new System.Windows.Forms.Button();
            this.Btn_GlobeSemaphore_Exit = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.Btn_Read = new System.Windows.Forms.Button();
            this.Btn_Write = new System.Windows.Forms.Button();
            this.Btn_AutoResetEvent_Set = new System.Windows.Forms.Button();
            this.Btn_AutoResetEvent_Wait = new System.Windows.Forms.Button();
            this.Btn_ManualResetEvent_Wait = new System.Windows.Forms.Button();
            this.Btn_ManueResetEvent_Set = new System.Windows.Forms.Button();
            this.Btn_WaitAny = new System.Windows.Forms.Button();
            this.Btn_WaitAll = new System.Windows.Forms.Button();
            this.Btn_DeadLock1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Monitor
            // 
            this.Monitor.Location = new System.Drawing.Point(185, 12);
            this.Monitor.Name = "Monitor";
            this.Monitor.Size = new System.Drawing.Size(83, 28);
            this.Monitor.TabIndex = 34;
            this.Monitor.Text = "Monitor";
            this.Monitor.UseVisualStyleBackColor = true;
            this.Monitor.Click += new System.EventHandler(this.Monitor_Click);
            // 
            // Btn_Lock
            // 
            this.Btn_Lock.Location = new System.Drawing.Point(274, 12);
            this.Btn_Lock.Name = "Btn_Lock";
            this.Btn_Lock.Size = new System.Drawing.Size(83, 28);
            this.Btn_Lock.TabIndex = 33;
            this.Btn_Lock.Text = "Lock";
            this.Btn_Lock.UseVisualStyleBackColor = true;
            this.Btn_Lock.Click += new System.EventHandler(this.Btn_Lock_Click);
            // 
            // Btn_Interlocked
            // 
            this.Btn_Interlocked.Location = new System.Drawing.Point(96, 12);
            this.Btn_Interlocked.Name = "Btn_Interlocked";
            this.Btn_Interlocked.Size = new System.Drawing.Size(83, 28);
            this.Btn_Interlocked.TabIndex = 32;
            this.Btn_Interlocked.Text = "Interlocked";
            this.Btn_Interlocked.UseVisualStyleBackColor = true;
            this.Btn_Interlocked.Click += new System.EventHandler(this.Btn_Interlocked_Click);
            // 
            // Btn_Normal
            // 
            this.Btn_Normal.Location = new System.Drawing.Point(16, 12);
            this.Btn_Normal.Name = "Btn_Normal";
            this.Btn_Normal.Size = new System.Drawing.Size(74, 28);
            this.Btn_Normal.TabIndex = 31;
            this.Btn_Normal.Text = "Normal";
            this.Btn_Normal.UseVisualStyleBackColor = true;
            this.Btn_Normal.Click += new System.EventHandler(this.Btn_Normal_Click);
            // 
            // Tb_ThreadInfo
            // 
            this.Tb_ThreadInfo.Location = new System.Drawing.Point(16, 209);
            this.Tb_ThreadInfo.Multiline = true;
            this.Tb_ThreadInfo.Name = "Tb_ThreadInfo";
            this.Tb_ThreadInfo.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Tb_ThreadInfo.Size = new System.Drawing.Size(579, 110);
            this.Tb_ThreadInfo.TabIndex = 19;
            // 
            // Btn_LocalMutex
            // 
            this.Btn_LocalMutex.Location = new System.Drawing.Point(385, 12);
            this.Btn_LocalMutex.Name = "Btn_LocalMutex";
            this.Btn_LocalMutex.Size = new System.Drawing.Size(91, 28);
            this.Btn_LocalMutex.TabIndex = 35;
            this.Btn_LocalMutex.Text = "局部Mutex";
            this.Btn_LocalMutex.UseVisualStyleBackColor = true;
            this.Btn_LocalMutex.Click += new System.EventHandler(this.Btn_LocalMutex_Click);
            // 
            // Btn_GlobeMutex_Enter
            // 
            this.Btn_GlobeMutex_Enter.Location = new System.Drawing.Point(482, 12);
            this.Btn_GlobeMutex_Enter.Name = "Btn_GlobeMutex_Enter";
            this.Btn_GlobeMutex_Enter.Size = new System.Drawing.Size(91, 28);
            this.Btn_GlobeMutex_Enter.TabIndex = 36;
            this.Btn_GlobeMutex_Enter.Text = "全局Mutex获取";
            this.Btn_GlobeMutex_Enter.UseVisualStyleBackColor = true;
            this.Btn_GlobeMutex_Enter.Click += new System.EventHandler(this.Btn_GlobeMutex_Enter_Click);
            // 
            // Btn_GlobeMutex_Exit
            // 
            this.Btn_GlobeMutex_Exit.Location = new System.Drawing.Point(588, 12);
            this.Btn_GlobeMutex_Exit.Name = "Btn_GlobeMutex_Exit";
            this.Btn_GlobeMutex_Exit.Size = new System.Drawing.Size(91, 28);
            this.Btn_GlobeMutex_Exit.TabIndex = 37;
            this.Btn_GlobeMutex_Exit.Text = "全局Mutex释放";
            this.Btn_GlobeMutex_Exit.UseVisualStyleBackColor = true;
            this.Btn_GlobeMutex_Exit.Click += new System.EventHandler(this.Btn_GlobeMutex_Exit_Click);
            // 
            // Btn_GlobeSemaphore_Enter
            // 
            this.Btn_GlobeSemaphore_Enter.Location = new System.Drawing.Point(166, 57);
            this.Btn_GlobeSemaphore_Enter.Name = "Btn_GlobeSemaphore_Enter";
            this.Btn_GlobeSemaphore_Enter.Size = new System.Drawing.Size(118, 28);
            this.Btn_GlobeSemaphore_Enter.TabIndex = 38;
            this.Btn_GlobeSemaphore_Enter.Text = "全局Semaphore获取";
            this.Btn_GlobeSemaphore_Enter.UseVisualStyleBackColor = true;
            this.Btn_GlobeSemaphore_Enter.Click += new System.EventHandler(this.Btn_GlobeSemaphore_Enter_Click);
            // 
            // Btn_GlobeSemaphore_Exit
            // 
            this.Btn_GlobeSemaphore_Exit.Location = new System.Drawing.Point(301, 57);
            this.Btn_GlobeSemaphore_Exit.Name = "Btn_GlobeSemaphore_Exit";
            this.Btn_GlobeSemaphore_Exit.Size = new System.Drawing.Size(118, 28);
            this.Btn_GlobeSemaphore_Exit.TabIndex = 39;
            this.Btn_GlobeSemaphore_Exit.Text = "全局Semaphore释放";
            this.Btn_GlobeSemaphore_Exit.UseVisualStyleBackColor = true;
            this.Btn_GlobeSemaphore_Exit.Click += new System.EventHandler(this.Btn_GlobeSemaphore_Exit_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(18, 57);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(133, 28);
            this.button1.TabIndex = 40;
            this.button1.Text = "初始化Semaphore计数";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // Btn_Read
            // 
            this.Btn_Read.Location = new System.Drawing.Point(455, 57);
            this.Btn_Read.Name = "Btn_Read";
            this.Btn_Read.Size = new System.Drawing.Size(89, 28);
            this.Btn_Read.TabIndex = 41;
            this.Btn_Read.Text = "读写锁_读";
            this.Btn_Read.UseVisualStyleBackColor = true;
            this.Btn_Read.Click += new System.EventHandler(this.Btn_Read_Click);
            // 
            // Btn_Write
            // 
            this.Btn_Write.Location = new System.Drawing.Point(564, 57);
            this.Btn_Write.Name = "Btn_Write";
            this.Btn_Write.Size = new System.Drawing.Size(102, 28);
            this.Btn_Write.TabIndex = 42;
            this.Btn_Write.Text = "读写锁_写";
            this.Btn_Write.UseVisualStyleBackColor = true;
            this.Btn_Write.Click += new System.EventHandler(this.Btn_Write_Click);
            // 
            // Btn_AutoResetEvent_Set
            // 
            this.Btn_AutoResetEvent_Set.Location = new System.Drawing.Point(20, 99);
            this.Btn_AutoResetEvent_Set.Name = "Btn_AutoResetEvent_Set";
            this.Btn_AutoResetEvent_Set.Size = new System.Drawing.Size(131, 28);
            this.Btn_AutoResetEvent_Set.TabIndex = 43;
            this.Btn_AutoResetEvent_Set.Text = "AutoResetEvent Set";
            this.Btn_AutoResetEvent_Set.UseVisualStyleBackColor = true;
            this.Btn_AutoResetEvent_Set.Click += new System.EventHandler(this.Btn_AutoResetEvent_Set_Click);
            // 
            // Btn_AutoResetEvent_Wait
            // 
            this.Btn_AutoResetEvent_Wait.Location = new System.Drawing.Point(166, 99);
            this.Btn_AutoResetEvent_Wait.Name = "Btn_AutoResetEvent_Wait";
            this.Btn_AutoResetEvent_Wait.Size = new System.Drawing.Size(157, 28);
            this.Btn_AutoResetEvent_Wait.TabIndex = 44;
            this.Btn_AutoResetEvent_Wait.Text = "Btn_AutoResetEvent_Wait";
            this.Btn_AutoResetEvent_Wait.UseVisualStyleBackColor = true;
            this.Btn_AutoResetEvent_Wait.Click += new System.EventHandler(this.Btn_AutoResetEvent_Wait_Click);
            // 
            // Btn_ManualResetEvent_Wait
            // 
            this.Btn_ManualResetEvent_Wait.Location = new System.Drawing.Point(510, 99);
            this.Btn_ManualResetEvent_Wait.Name = "Btn_ManualResetEvent_Wait";
            this.Btn_ManualResetEvent_Wait.Size = new System.Drawing.Size(157, 28);
            this.Btn_ManualResetEvent_Wait.TabIndex = 46;
            this.Btn_ManualResetEvent_Wait.Text = "ManualResetEvent  Wait";
            this.Btn_ManualResetEvent_Wait.UseVisualStyleBackColor = true;
            this.Btn_ManualResetEvent_Wait.Click += new System.EventHandler(this.Btn_ManualResetEvent_Wait_Click);
            // 
            // Btn_ManueResetEvent_Set
            // 
            this.Btn_ManueResetEvent_Set.Location = new System.Drawing.Point(347, 99);
            this.Btn_ManueResetEvent_Set.Name = "Btn_ManueResetEvent_Set";
            this.Btn_ManueResetEvent_Set.Size = new System.Drawing.Size(148, 28);
            this.Btn_ManueResetEvent_Set.TabIndex = 45;
            this.Btn_ManueResetEvent_Set.Text = "ManualResetEvent  Set";
            this.Btn_ManueResetEvent_Set.UseVisualStyleBackColor = true;
            this.Btn_ManueResetEvent_Set.Click += new System.EventHandler(this.Btn_ManueResetEvent_Set_Click);
            // 
            // Btn_WaitAny
            // 
            this.Btn_WaitAny.Location = new System.Drawing.Point(20, 145);
            this.Btn_WaitAny.Name = "Btn_WaitAny";
            this.Btn_WaitAny.Size = new System.Drawing.Size(105, 28);
            this.Btn_WaitAny.TabIndex = 47;
            this.Btn_WaitAny.Text = "WaitAny";
            this.Btn_WaitAny.UseVisualStyleBackColor = true;
            this.Btn_WaitAny.Click += new System.EventHandler(this.Btn_WaitAny_Click);
            // 
            // Btn_WaitAll
            // 
            this.Btn_WaitAll.Location = new System.Drawing.Point(166, 145);
            this.Btn_WaitAll.Name = "Btn_WaitAll";
            this.Btn_WaitAll.Size = new System.Drawing.Size(105, 28);
            this.Btn_WaitAll.TabIndex = 48;
            this.Btn_WaitAll.Text = "WaitAll";
            this.Btn_WaitAll.UseVisualStyleBackColor = true;
            this.Btn_WaitAll.Click += new System.EventHandler(this.Btn_WaitAll_Click);
            // 
            // Btn_DeadLock1
            // 
            this.Btn_DeadLock1.Location = new System.Drawing.Point(314, 145);
            this.Btn_DeadLock1.Name = "Btn_DeadLock1";
            this.Btn_DeadLock1.Size = new System.Drawing.Size(105, 28);
            this.Btn_DeadLock1.TabIndex = 49;
            this.Btn_DeadLock1.Text = "死锁示例";
            this.Btn_DeadLock1.UseVisualStyleBackColor = true;
            this.Btn_DeadLock1.Click += new System.EventHandler(this.Btn_DeadLock1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(678, 357);
            this.Controls.Add(this.Btn_DeadLock1);
            this.Controls.Add(this.Btn_WaitAll);
            this.Controls.Add(this.Btn_WaitAny);
            this.Controls.Add(this.Btn_ManualResetEvent_Wait);
            this.Controls.Add(this.Btn_ManueResetEvent_Set);
            this.Controls.Add(this.Btn_AutoResetEvent_Wait);
            this.Controls.Add(this.Btn_AutoResetEvent_Set);
            this.Controls.Add(this.Btn_Write);
            this.Controls.Add(this.Btn_Read);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.Btn_GlobeSemaphore_Exit);
            this.Controls.Add(this.Btn_GlobeSemaphore_Enter);
            this.Controls.Add(this.Btn_GlobeMutex_Exit);
            this.Controls.Add(this.Btn_GlobeMutex_Enter);
            this.Controls.Add(this.Btn_LocalMutex);
            this.Controls.Add(this.Monitor);
            this.Controls.Add(this.Btn_Lock);
            this.Controls.Add(this.Btn_Interlocked);
            this.Controls.Add(this.Btn_Normal);
            this.Controls.Add(this.Tb_ThreadInfo);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Monitor;
        private System.Windows.Forms.Button Btn_Lock;
        private System.Windows.Forms.Button Btn_Interlocked;
        private System.Windows.Forms.Button Btn_Normal;
        private System.Windows.Forms.TextBox Tb_ThreadInfo;
        private System.Windows.Forms.Button Btn_LocalMutex;
        private System.Windows.Forms.Button Btn_GlobeMutex_Enter;
        private System.Windows.Forms.Button Btn_GlobeMutex_Exit;
        private System.Windows.Forms.Button Btn_GlobeSemaphore_Enter;
        private System.Windows.Forms.Button Btn_GlobeSemaphore_Exit;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button Btn_Read;
        private System.Windows.Forms.Button Btn_Write;
        private System.Windows.Forms.Button Btn_AutoResetEvent_Set;
        private System.Windows.Forms.Button Btn_AutoResetEvent_Wait;
        private System.Windows.Forms.Button Btn_ManualResetEvent_Wait;
        private System.Windows.Forms.Button Btn_ManueResetEvent_Set;
        private System.Windows.Forms.Button Btn_WaitAny;
        private System.Windows.Forms.Button Btn_WaitAll;
        private System.Windows.Forms.Button Btn_DeadLock1;
    }
}

