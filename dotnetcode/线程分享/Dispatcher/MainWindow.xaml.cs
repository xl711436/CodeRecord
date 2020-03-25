using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace Dispatcher
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.Loaded += MainWindow_Loaded;
        }

        void MainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            Tb_Name.Text = "localCache";

            DelayRunDispatchAction(this, 1000, () => {

                Thread.Sleep(1000);
                Tb_Name.Text = "remoteinfo";
            });
            //加个动画， 试验界面不停顿

        }

        public static void DelayRunDispatchAction(DispatcherObject I_DispatcherObject,int I_DelayTime,Action I_Action)
        {
            
            new Thread(new ThreadStart(()=>{
                Thread.Sleep(I_DelayTime);
                I_DispatcherObject.Dispatcher.BeginInvoke(I_Action);
            })).Start();
        }
    }
}
