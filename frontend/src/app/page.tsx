import { Login } from "@/components/ui/login";
import Image from "next/image";

export default function Home() {
  return (
    <div className="grid grid-cols-1 max-w-[500px] m-auto py-20">
      <Login></Login>
    </div>
  );
}
