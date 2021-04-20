package top.niunaijun.blackbox.entity.pm;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;

import top.niunaijun.blackbox.BlackBoxCore;

/**
 * Created by Milk on 4/20/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class InstalledPackage implements Parcelable {
    private int userId;
    private String packageName;

    public ApplicationInfo getApplication() {
        return BlackBoxCore.getBPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA, userId);
    }

    public PackageInfo getPackageInfo() {
        return BlackBoxCore.getBPackageManager().getPackageInfo(packageName, PackageManager.GET_META_DATA, userId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeString(this.packageName);
    }

    public InstalledPackage() {
    }

    protected InstalledPackage(Parcel in) {
        this.userId = in.readInt();
        this.packageName = in.readString();
    }

    public static final Parcelable.Creator<InstalledPackage> CREATOR = new Parcelable.Creator<InstalledPackage>() {
        @Override
        public InstalledPackage createFromParcel(Parcel source) {
            return new InstalledPackage(source);
        }

        @Override
        public InstalledPackage[] newArray(int size) {
            return new InstalledPackage[size];
        }
    };
}
