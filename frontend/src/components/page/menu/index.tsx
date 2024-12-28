import Image from "next/image";
import Link from "next/link";
import AppIcon from "../../../app/icon.png";

import { HomeIcon, LogOut, UserRound } from "lucide-react";
import TweetDialog from "@/components/tweet-dialog";

export default function PageMenu() {
  return (
    <nav className="flex flex-auto m-auto w-full px-4">
      <div className="flex flex-col gap-2">
        <Link href="/"
          className="flex max-w-[64px] gap-4 rounded-full p-4 hover:bg-menu-hover text-lg">
          <div>
            <Image src={AppIcon} width={32} height={32} alt="Icone" />
          </div>
        </Link>
        <Link href="/home"
          className="flex gap-4 rounded-full p-4 hover:bg-menu-hover text-lg">
          <div>
            <HomeIcon />
          </div>
          <div>
            Home
          </div>
        </Link>
        <Link href="/profile"
          className="flex gap-4 rounded-full p-4 hover:bg-menu-hover text-lg">
          <div>
            <UserRound />
          </div>
          <div>
            Perfil
          </div>
        </Link>
        <Link href="/"
          className="flex gap-4 rounded-full p-4 hover:bg-menu-hover text-lg">
          <div>
            <LogOut />
          </div>
          <div>
            Sair
          </div>
        </Link>

        <div className="m-auto w-full">
          <TweetDialog></TweetDialog>
        </div>
      </div>
    </nav >
  )
}
