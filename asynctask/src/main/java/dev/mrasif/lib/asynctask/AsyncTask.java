package dev.mrasif.lib.asynctask;

import android.os.Handler;
import android.os.Looper;

public abstract class AsyncTask<Params,Progress,Result> extends Thread{
    private Params[] params;
    private Result result;
    private CompleteListener<Result> completeListener;
    private ProgressListener<Progress> progressListener;

    public AsyncTask() {
    }

    public AsyncTask(CompleteListener<Result> completeListener){
        this.completeListener=completeListener;
    }

    public AsyncTask(CompleteListener<Result> completeListener, ProgressListener<Progress> progressListener){
        this.completeListener=completeListener;
        this.progressListener=progressListener;
    }

    public void onComplete(CompleteListener<Result> completeListener){
        this.completeListener=completeListener;
    }

    public void onProgressUpdate(ProgressListener<Progress> progressListener){
        this.progressListener=progressListener;
    }

    @SafeVarargs
    public final void execute(Params... params){
        this.params=params;
        start();
    }

    @Override
    public final void run() {
        super.run();
        onPreExecute(params);
        this.result=doInBackground(params);

        new Handler(Looper.getMainLooper()).post(() -> {
            if (null!=completeListener){
                completeListener.onCompleted(result);
            }
            onPostExecute(result);
        });
    }

    public abstract void onPreExecute(Params... params);

    public abstract Result doInBackground(Params... params);

    public abstract void onPostExecute(Result result);

    final void publishProgress(Progress progress){
        new Handler(Looper.getMainLooper()).post(() -> {
            if (null != progressListener) {
                progressListener.onProgressUpdate(progress);
            }
        });
    }

    public interface CompleteListener<Result>{
        void onCompleted(Result result);
    }
    public interface ProgressListener<Progress>{
        void onProgressUpdate(Progress progress);
    }

}
