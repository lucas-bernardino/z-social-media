import Link from "next/link";
import { ReactNode } from "react";
import { Avatar, AvatarFallback, AvatarImage } from "../ui/avatar";

export default function SplitedContainer({ children }: { children: ReactNode }) {

  const profileImage = (
    <Avatar>
      <AvatarImage src="http://github.com/lucas-bernardino.png" />
      <AvatarFallback>D</AvatarFallback>
    </Avatar>
  )

  return (
    <div className="flex w-full p-4 ">
      <Link href="#" className="px-4">
        {profileImage}
      </Link>
      <div className="flex flex-col w-full justify-center m-auto gap-4">
        {children}
      </div>
    </div>
  )
}
